package code.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Author: xl
 * date :2020/12/29 10:53
 * description:
 * ArrayList集合：底层是数组结构实现，查询快、增删慢
 * LinkedList集合：底层是链表结构实现，查询慢、增删快
 *  方法	说明
 * public void addFirst(E e)	在该列表开头插入指定的元素
 * public void addLast(E e)	在该列表末尾追加指定的元素
 * public E getFirst()	返回此列表中的第一个元素
 * public E getLast()	返回此列表中的最后一个元素
 * public E removeFirst()	从此列表中删除并返回第一个元素
 * public E removeLast()	从此列表中删除并返回最后一个元素
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ArrayListTest3 {
    public static void main(String[] args) {
        // 创建集合
        List<String> list = new ArrayList<String>();

        // 添加元素
        list.add("张三");
        list.add("张三");
        list.add("李四");
        list.add("李四");
        list.add("王五");
        list.add("王五");
        System.out.println(list.toString());

        // List独有方法：E get(int index)
        String s = list.get(0);
        System.out.println(s);

        // List独有方法：E set(int index, E element)
        list.set(2, "xiaoqi");
        System.out.println(list.toString());

        // List独有方法：ListIterator<E> listIterator()
        ListIterator<String> listIterator = list.listIterator();
        // 使用列表迭代器：从前向后迭代
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        // 使用列表迭代器：从后向前迭代
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        // List独有遍历：普通for循环遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
