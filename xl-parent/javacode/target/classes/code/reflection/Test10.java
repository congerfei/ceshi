package code.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Author: xl
 * date :2020/12/5 16:35
 * description: 获取方法中的泛型
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Test10 {


    public static void main(String[] args) throws Exception{
        Method method = Test10.class.getMethod("test01", Map.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();//得到所有的参数类型
        method.getGenericExceptionTypes();//获取方法抛出的异常
        method.getGenericReturnType();//获取方法的返回类型

        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("##"+genericParameterType); //Map<java.lang.String, code.reflection.User> ,java.util.List<code.reflection.User>
            if(genericParameterType instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }

        }



    }


    //方法参数中的泛型
    public void test01(Map<String, User> map,List<User>list){
        System.out.println("test01");
    }

    //返回参数的泛型
    public Map<String,User> test02(){
        System.out.println("test02");
        return null;
    }




}
