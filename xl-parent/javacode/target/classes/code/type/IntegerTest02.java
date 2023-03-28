package code.type;

/**
 * Author: xl
 * date :2020/12/29 9:54
 * description:
 *
 * 基本类型	包装类
 * byte	    Byte
 * short	Short
 * int	    Integer
 * long 	Long
 * float	Float
 * double	Double
 * char 	Character
 * boolean	Boolean
 *
 * 自动装箱：把基本数据类型转换为对应的包装类类型
 * 自动拆箱：把包装类类型转换为对应的基本数据类型
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class IntegerTest02 {
    public static void main(String[] args) {
        int i = 1;
        Integer j = 2;
        Integer a = i + j;//先将 j 拆箱成int 然后将结果自动装箱成Integer
        System.out.println(a);
    }

}
