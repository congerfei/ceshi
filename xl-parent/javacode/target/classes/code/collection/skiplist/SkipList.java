package code.collection.skiplist;

import java.util.Random;
/**
 * 跳表的实现:跳表模型
 *  脑海中有一个临时节点，就像指针一样，就是当前遍历的位置
 *  主要关注查找 和 新增的思想
 */
public class SkipList {
    // 节点数量
    public int n;
    // 节点最大层数
    public int h;

    // 第一个节点
    SkipListEntry head;
    // 最后一个节点
    SkipListEntry tail;

    public Random r;


    public SkipList() {
        // 创建 head 节点
        this.head = new SkipListEntry(Integer.MIN_VALUE, null);
        // 创建 tail 节点
        this.tail = new SkipListEntry(Integer.MAX_VALUE, null);

        // 将 head 节点的右指针指向 tail 节点
        this.head.right = tail;
        // 将 tail 节点的左指针指向 head 节点
        this.tail.left = head;

        this.h = 0;
        this.n = 0;
        this.r = new Random();
    }

    /**
     * 跳表是如何查找的呢?
     * 从哪里开始？head 开始  然后和head的右节点的值对比，如果比他小，则“指针”右移动
     * 直到碰到大的，则指针下移动（如果没有向下的对象说明就是最底层了）继续对比该指针的右节点，直到找到该值的位置
     * 如果没有这个值 择该指针的右节点是null
     * @param key
     * @return
     */
    private SkipListEntry findEntry(Integer key) {
        // 从head头节点开始查找
        SkipListEntry p = head;

        while (true) {
            // 从左向右查找，直到右节点的key值大于要查找的key值
            while (p.right.key <= key) {
                p = p.right;
            }

            // 如果有更低层的节点，则向低层移动
            if (p.down != null) {
                p = p.down;
            } else {
                break;
            }
        }
        //如果没找到返回的是个null
        return p.right;
    }

    /**
     *  新增的规则也挺简单的，和查找的规则差不多，如果找到就改，找到下节点是null 且右节点的值要大，指针和右节点中间就是可以插入的位置，
     *  插入后如何建立层级关系？也挺简单的，根据随机数r属性来控制，如果是0 就不给他创建上层级节点
     *  如果是其他数（但是要小于最大层数），就创建到该层级，然后建立几个上节点，并设置该几个上节点的左右节点
     * @param key
     * @param value
     * @return
     */
    public Object put(Integer key, Object value) {

        SkipListEntry p, q;
        int i = 0;

        // 查找适合插入的位子
        p = findEntry(key);

        // 如果跳跃表中存在含有key值的节点，则进行value的修改操作即可完成
        if (p.key.equals(key)) {
            Object oldValue = p.value;
            p.value = value;
            return oldValue;
        }

        // 如果跳跃表中不存在含有key值的节点，则进行新增操作
        q = new SkipListEntry(key, value);
        q.left = p;
        q.right = p.right;
        p.right.left = q;
        p.right = q;

        // 再使用随机数决定是否要向更高level攀升
        while (r.nextDouble() < 0.5) {

            // 如果新元素的级别已经达到跳跃表的最大高度，则新建空白层
            if (i >= h) {
                addEmptyLevel();
            }

            // 从p向左扫描含有高层节点的节点
            while (p.up == null) {
                p = p.left;
            }
            p = p.up;

            // 新增和q指针指向的节点含有相同key值的节点对象
            // 这里需要注意的是除底层节点之外的节点对象是不需要value值的
            SkipListEntry z = new SkipListEntry(key, null);

            z.left = p;
            z.right = p.right;
            p.right.left = z;
            p.right = z;

            z.down = q;
            q.up = z;

            q = z;
            i = i + 1;
        }

        n = n + 1;

        // 返回null，没有旧节点的value值
        return null;
    }

    private void addEmptyLevel() {
    }

    public Object get(Integer key) {
        SkipListEntry p = findEntry(key);

        if (p.key.equals(key)) {
            return p.value;
        } else {
            return null;
        }
    }


    public Object remove(Integer key) {
        SkipListEntry p, q;

        p = findEntry(key);

        if (!p.key.equals(key)) {
            return null;
        }

        Object oldValue = p.value;
        while (p != null) {
            q = p.up;
            p.left.right = p.right;
            p.right.left = p.left;
            p = q;
        }
        return oldValue;
    }





}
