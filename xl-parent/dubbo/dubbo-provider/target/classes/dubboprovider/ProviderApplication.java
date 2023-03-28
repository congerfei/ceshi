package dubboprovider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Author: xl
 * date :2020/11/29 14:41
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ProviderApplication {

    public static void main(String[] args) throws IOException {
        //加载xml配置文件启动
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/provider.xml");
        context.start();

        //避免spring运行完关闭
        System.in.read();
    }

}
