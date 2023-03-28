package code.type;

/**
 *  java只有值传递
 *  形参   ||   实参
 *
 *  如果参数是基本类型的话，很简单，传递的就是基本类型的字面量值的拷贝，会创建副本。
 *  如果参数是引用类型，传递的就是实参所引用的对象在堆中地址值的拷贝，同样也会创建副本。
 */
public class ChuangZhi {

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        swap(num1, num2);//------- 操作是  （形参）a = num1（实参） , b = num2,  然后才进入  swap(int a, int b)方法进行操作 ,所以要注意基础数据类型传值的情况
        System.out.println("num1 = " + num1);//10
        System.out.println("num2 = " + num2);//20
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }


}
