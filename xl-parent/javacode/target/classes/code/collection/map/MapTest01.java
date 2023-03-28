package code.collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/**
 * Author: xl
 * date :2020/12/29 10:39
 * description:map
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class MapTest01 {
    public static void main(String[] args) {
        // 创建集合
        Map<String, String> map = new HashMap<String, String>();

        // 添加元素
        map.put("吕布", "貂蝉");
        map.put("项羽", "虞姬");
        map.put("郭靖", "黄蓉");
        map.put("后裔", "嫦娥");
        System.out.println(map.toString());

        // 删除元素
        map.remove("郭靖");
        System.out.println(map.toString());

        // 判断集合是否包含指定键
        boolean containsKey = map.containsKey("吕布");
        System.out.println(containsKey);

        // 判断集合是否包含指定值
        boolean containsValue = map.containsValue("貂蝉");
        System.out.println(containsValue);

        // 判断集合是否为空
        boolean isEmpty = map.isEmpty();
        System.out.println(isEmpty);

        // 获取集合元素个数
        int size = map.size();
        System.out.println(size);

        // 清空集合所有元素
        map.clear();
        System.out.println(map.toString());

        // 添加另外集合元素
        Map<String, String> m = new HashMap<String, String>();
        m.put("张三", "李四");
        m.put("王五", "小六");
        map.putAll(m);
        System.out.println(map.toString());

        // 根据键获取值
        System.out.println(map.get("张三"));

        // 获取所有键的集合
        Set<String> keySet = map.keySet();
        // 迭代器遍历
        Iterator<String> keysIterator = keySet.iterator();
        while (keysIterator.hasNext()) {
            System.out.println(keysIterator.next());
        }
        // 增强for遍历
        for (String key : keySet) {
            System.out.println(key);
        }

        // 获取所有值的集合
        Collection<String> values = map.values();
        // 迭代器遍历
        Iterator<String> valuesIterator = values.iterator();
        while (valuesIterator.hasNext()) {
            System.out.println(valuesIterator.next());
        }
        // 增强for遍历
        for (String value : values) {
            System.out.println(value);
        }

        // 获取所有键值对对象的集合
        Set<Entry<String, String>> entrySet = map.entrySet();
        // 迭代器遍历
        Iterator<Entry<String, String>> entrySetIterator = entrySet.iterator();
        while (entrySetIterator.hasNext()) {
            Entry<String, String> entry = entrySetIterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }
        // 增强for遍历
        for (Entry<String, String> entry : entrySet) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }
    }
}
