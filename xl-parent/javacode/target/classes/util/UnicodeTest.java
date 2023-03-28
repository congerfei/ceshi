package util;

import lombok.extern.java.Log;
import org.junit.Before;
import org.junit.Test;

/**
 *      *  正数的原码、反码、补码均相同
 *      *
 *      * 负数的原码、反码、补码各不相同
 *      *      负数的原码：直接将负数翻译成二进制就可以得到原码
 *      *
 *      *      负数的反码：原码符号位不变。其它位按位取反即可得反码
 *      *
 *      *      负数的补码：反码+1=补码
 */
@Log
public class UnicodeTest {

    @Before
    public void init(){

    }

    /**
     *  ASCII码
     *  1 字节对应 8 位二进制数  00000000    2的8次方 = 256
     *  但是第一个是符号位空闲的，只有127个  每一个对应一个符号，整体就是 ASCII 码
     *
     *
     */
    @Test
    public void test01(){
        for (int i = 0; i < 128;i++) {
            char ch = (char) i;    //第九个是换行符
            System.out.print(ch+" ");
        }

    }

    /**
     * UTF-16BE    汉子编码
     *  char 是16位 2个字节，存放一个汉子是够的
     */
    @Test
    public void test02(){
        System.out.println((char) 25105); //10进制的  对应16进制的 FEFF6211

    }

    @Test
    public void test03(){
        char ch = '我';
        System.out.println(ch);
        System.out.println(new Integer(ch));  //25105
    }


}
