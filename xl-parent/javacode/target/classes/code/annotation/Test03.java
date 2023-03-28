package code.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: xl
 * date :2020/12/5 12:40
 * description:自定义注解
 *      0.注解的定义：@interface A{}
 *      1.注解的参数，并不是一个方法：参数类型 参数名(),如果定义了参数不给参数就会报错，那我们可以后面定义一个默认的参数值default
 *      2.只有一个参数的建议使用value命名，这样就可以用的时候只用参数值就行了
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */

public class Test03 {

    @MyAnnotation2(name="xl")
    public void test(){
    }

    @MyAnnotation3("xl")
    public void test2(){

    }


}

@Target({ElementType.METHOD,ElementType.TYPE})//因为该注解只有一个属性，所以可以省略掉value = ，只写参数值即可
@Retention(RetentionPolicy.RUNTIME)
@interface  MyAnnotation2{
    //注解的参数，并不是一个方法：参数类型 参数名(),如果定义了参数不给参数就会报错，那我们可以后面定义一个默认的参数值
    String name();
    int age() default 18;
    int id() default -1;
    String[] school() default {"湖北科技学院"};
}


@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface  MyAnnotation3{
    String value();//只有一个参数的建议使用value命名
}
