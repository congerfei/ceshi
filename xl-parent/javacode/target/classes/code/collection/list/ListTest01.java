package code.collection.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 *  List  是一个接口规范，需要其他实现类
 *  集合特点
 *      1.有序 : 存储和取出的元素顺序一致
 *      2.可重复
 */
public class ListTest01 {

    ArrayList alist = null;

    @Before
    public void init(){
        alist = new ArrayList();

        alist.add("hello");
        alist.add("object");
        alist.add("java");
        alist.add("python");
        alist.add("c++");
    }

    /**
     *  ArrayList  实现了 List接口规范，输出的顺序和添加的顺序一致
     *     ArrayList内部是使用数组进行实现的
     */
    @Test
    public void test01(){
        System.out.println(alist);   //[hello, object, java, python, c++]
    }


}
