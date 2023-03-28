package code.collection.array;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Author: xl
 * date :2020/12/11 10:53
 * description: 数组：数组是用于储存多个相同类型数据的集合。
 *              特性：不可变 （属性：length）
 *
 *              不用的数组就浪费了
 *              超过设置的个数，又放不下 ----------引入集合的概念
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
@Slf4j
public class ArrrayTest {

    /**
     * 数组的声明
     */
    String[] array = new String[10];

    /**
     * 数组的初始化
     */
    @Before
    public void before(){
        array[0]="聪聪";
        array[1]="小冷";
        array[2]="血舞飞仙";
        array[3] = "congerfei";
        array[4] = "聪儿飞";
        array[5] = "小薇";
        array[6] = "小明";
        array[7] = "娇娇";
        array[8] = "红红";
        array[9]="小阳阳";


    }

    @Test
    public  void test1(){
        int[] arr = new int[5];//定义一个大小为5的数组，存放的数据是int类型，并数组中的值都有默认值
        //如果只定义了引用不开辟堆内存空间，却去使用就会报错 NullPointerException”异常

        //避免使用数组的时候出现越界异常，java1.5版本后建议使用foreach
        for (int i : arr) {
            System.out.print(i);
        }

        //数组新增 ,如果插入两个元素中间的时候,需要将后面的后移
        arr[1]=1;

        System.out.println(Arrays.toString(arr));

        //数组查询,先用for循环遍历
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                System.out.println(i);
            }
        }

        //删除，也需要先遍历，删除中间的需要后面的前移

    }

    /**
     *   数组可能会报的错：
     *   1.数组越界并不会报编译错误，会报运行错误   java.lang.ArrayIndexOutOfBoundsException: 10
     *   2.如果没有初始化，直接使用会报空指针异常
     */
    @Test
    public  void test2(){
        array[10] = "小林林";
        System.out.println("我测试一下 超过了会不会报错");
    }

    /**
     *    数组是有属性的   length
     *    [main] INFO code.collection.array.ArrrayTest2 - length:10
     */
    @Test
    public  void test3(){
        int length = array.length;
        log.info("length:"+length);

    }

    /**
     *    [Ljava.lang.String;@11028347
     *
     */
    @Test
    public  void test4(){
        log.info(String.valueOf(array));

    }

    /**
     * 数组的遍历
     *   1.forEach进行遍历
     *   2.通过属性大小进行for循环遍历
     */
    @Test
    public  void test5(){

        log.info(Arrays.toString(array));
        log.info("-----------------");
        /**
         * foreach
         */
        for (String s : array) {
            log.info(s);
        }
        log.info("-----------------");

        /**
         *  遍历长度
         */
        for (int i = 0; i < array.length; i++) {
            log.info(array[i]);
        }
    }

    /**
     *  Arrays 操作类
     */
    @Test
    public  void test6(){
        Arrays.sort(array);  //将数组按照升序排列
        log.info(Arrays.toString(array));
    }


    @Test
    public  void test7(){
        if(7>0){
            log.info("1");
        }else if(8>0){
            log.info("2");
        }else if(9>0){
            log.info("3");
        }else{
            log.info("4");
        }
    }







}
