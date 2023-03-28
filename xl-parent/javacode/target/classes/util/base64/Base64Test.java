package util.base64;


import lombok.extern.java.Log;
import org.junit.Before;
import org.junit.Test;

import java.util.Base64;

@Log
public class Base64Test {

    byte[] bytes = "Hello,World".getBytes();

    /**
     * 测试base64加密
     */
    @Before
    public void init(){
        log.info(new String(bytes));
    }

    /**
     *
     *  测试base64加解密
     */
    @Test
    public void test01(){
        bytes = Base64.getEncoder().encode(bytes);
        System.out.println("编码后：" + new String(bytes));


        bytes = Base64.getDecoder().decode(bytes);
        System.out.println("解码后：" + new String(bytes));
    }

    /**
     *  解码某一个 加密字符串   eyJhbGciOiJIUzI1NiJ9
     */
    @Test
    public void test02(){
        String s = "eyJhbGciOiJIUzI1NiJ9";
        byte[] bytes = s.getBytes();
        bytes = Base64.getDecoder().decode(bytes);
        System.out.println("解码后：" + new String(bytes));
    }

    @Test
    public void test03(){

    }
}
