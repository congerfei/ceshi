package code.collection.list;

import java.util.LinkedList;

/**
 * Author: xl
 * date :2020/9/28 14:46
 * description:LinkedList详解
 *     toArray()  以正确的顺序（从第一个到最后一个元素）返回一个包含此列表中所有元素的数组
 *     size()  返回此列表中的元素数
 *     set(int index,E element)  用指定的元素替换此列表中指定位置的元素
 *     removeLast()  从此列表中删除并返回最后一个元素
 *     removeFirst()  从此列表中删除并返回第一个元素
 *     remove(int index)  删除该列表中指定位置的元素
 *     getFirst()  返回此列表中的第一个元素
 *     getLast()  返回此列表中的最后一个元素
 *     get(int index)  返回此列表中指定位置的元素
 *     add(E element)  将指定的元素追加到此列表的末尾
 *     add(int index,E element)  在此列表中的指定位置插入指定的元素
 *     addFirst(E element)  在该列表开头插入指定的元素
 *     addLast(E element)   将指定的元素追加到此列表的末尾
 *     clear()  从列表中删除所有元素
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class LinkedListTest {
    public static void main(String[] args) {
        Person p1 = new Person("张三", 22);
        Person p2 = new Person("李四", 23);
        Person p3 = new Person("王五", 18);

        LinkedList<Person> linkedList=new LinkedList<>();
        linkedList.addFirst(p3);
        linkedList.add(p2);
        linkedList.addLast(p1);

        //getFirst()  返回此列表中的第一个元素
        System.out.println(linkedList.getFirst());
        //getLast()  返回此列表中的最后一个元素
        System.out.println(linkedList.getLast());
        System.out.println("----------------");

        //toArray()  以正确的顺序（从第一个到最后一个元素）返回一个包含此列表中所有元素的数组
        Object[] persons=linkedList.toArray();
        System.out.println(persons[0]);



    }




}
