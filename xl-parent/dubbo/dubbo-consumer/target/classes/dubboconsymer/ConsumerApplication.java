package dubboconsymer;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import dubbointerface.service.ProviderService;

import java.io.IOException;

/**
 * Author: xl
 * date :2020/11/29 16:56
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ConsumerApplication {

    public static void main( String[] args ) throws IOException {

        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("MATA-INF/spring/consumer.xml");
        context.start();
        ProviderService providerService = (ProviderService) context.getBean("providerService");
        String str = providerService.sayHello("hello");
        System.out.println(str);

        System.in.read();//防止应用自动关闭

    }
}
