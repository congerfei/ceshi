package code.annotation;

import java.lang.annotation.*;

/**
 * Author: xl
 * date :2020/12/5 12:23
 * description:测试元注解 meta-code.annotation
 *      @Target  表示我们的注解使用在哪个位置
 *      @Retention 表示我们的注解在什么阶段有效，Source有源注解才有效，Class有在class类时候才有效，RUNTIME有在运行时候也有效
 *      @Documented 表示是否生成文档
 *      @Inherited  表示子类可以继承父类的注解
 *
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Test02 {

    @MyAnnotation
    public void testAnnotation(){

    }

}

//自定义注解,约束作用域在一个方法上，如果使用在其他位置会报错,可以使用value = {ElementType.METHOD，..}就可以使用在多个位置
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation{

}
