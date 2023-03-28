package code.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: xl
 * date :2020/12/2 10:43
 * description:ArrayList 是通过下标访问得，新增可以随便插入的，删除也是可以任意删除的，所以需要移动其他数据的位置----查询快，增删慢的原理
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ArrayListTest2 {

    public static void main(String[] args) {

        List list = new ArrayList<>(); //从0开始
        list.add(100);
        list.add("xl");

        int[] arr = new int[]{1,2,3,4,5};
        list.add(arr);//数组也是可以放进集合中得，取出来得时候需要强转一下，实际用得时候一般都会使用泛型对集合得数据进行规范

        //list.forEach(System.out::println);
        int[] o =(int[]) list.get(2);
        System.out.println(o[0]);

        int xl = list.indexOf(100);//是需要遍历数组的，如果没有该元素返回 -1
        System.out.println("xl元素所存放的位置："+xl);

    }



}
