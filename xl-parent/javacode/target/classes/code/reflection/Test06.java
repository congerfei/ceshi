package code.reflection;

/**
 * Author: xl
 * date :2020/12/5 14:52
 * description: 类加载器
 *  结果：
 *  sun.misc.Launcher$AppClassLoader@18b4aac2       获取系统类的加载器
 * sun.misc.Launcher$ExtClassLoader@3a71f4dd        扩展类加载器
 * null                                             根加载器
 * 这里扩展下双亲委派机制：就是你写的类会被类加载器依次检测（最后是根加载器），如果你写的类和他们的类名重合了则会运行不通过的
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Test06 {


    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取系统类加载器的父类-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);//sun.misc.Launcher$ExtClassLoader@3a71f4dd

        //获取扩展类加载器的父类--->根加载器
        ClassLoader loader = parent.getParent();
        System.out.println(loader);//null

        //获取某个类是哪个加载器加载的,现在测试下当前类是谁加载的
        ClassLoader classLoader = Class.forName("code.reflection.Test06").getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //测试下jdk内置的类是谁加载的,rt.jar 包下的
        ClassLoader classLoader2 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader2);//null

        //获取类加载的路径，也就是哪些路径下的类能被正常加载
        String str = System.getProperty("java.class.path");
        System.out.println(str);//我们这里就比较多了，因为引入了springcloud，springboot了，大致了解下就行
        //D:\Java\jdk1.8.0_191\jre\lib\charsets.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\deploy.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\ext\access-bridge-64.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\ext\cldrdata.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\ext\dnsns.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\ext\jaccess.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\ext\jfxrt.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\ext\localedata.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\ext\nashorn.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\ext\sunec.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\ext\sunjce_provider.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\ext\sunmscapi.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\ext\sunpkcs11.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\ext\zipfs.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\javaws.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\jce.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\jfr.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\jfxswt.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\jsse.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\management-agent.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\plugin.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\resources.jar;
        // D:\Java\jdk1.8.0_191\jre\lib\rt.jar;
        // D:\congerfei\code\ceshi\xl-parent\springboot2-test\javacode\target\classes;
        // D:\congerfei\mavenrepository\mysql\mysql-connector-java\8.0.19\mysql-connector-java-8.0.19.jar;
        // D:\congerfei\mavenrepository\org\springframework\boot\spring-boot-starter-web\2.2.4.RELEASE\spring-boot-starter-web-2.2.4.RELEASE.jar;
        // D:\congerfei\mavenrepository\org\springframework\boot\spring-boot-starter\2.2.4.RELEASE\spring-boot-starter-2.2.4.RELEASE.jar;
        // D:\congerfei\mavenrepository\org\springframework\boot\spring-boot\2.2.4.RELEASE\spring-boot-2.2.4.RELEASE.jar;
        // D:\congerfei\mavenrepository\org\springframework\boot\spring-boot-autoconfigure\2.2.4.RELEASE\spring-boot-autoconfigure-2.2.4.RELEASE.jar;
        // D:\congerfei\mavenrepository\org\springframework\boot\spring-boot-starter-logging\2.2.4.RELEASE\spring-boot-starter-logging-2.2.4.RELEASE.jar;
        // D:\congerfei\mavenrepository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;
        // D:\congerfei\mavenrepository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;
        // D:\congerfei\mavenrepository\org\apache\logging\log4j\log4j-to-slf4j\2.12.1\log4j-to-slf4j-2.12.1.jar;
        // D:\congerfei\mavenrepository\org\apache\logging\log4j\log4j-api\2.12.1\log4j-api-2.12.1.jar;
        // D:\congerfei\mavenrepository\org\slf4j\jul-to-slf4j\1.7.30\jul-to-slf4j-1.7.30.jar;
        // D:\congerfei\mavenrepository\jakarta\code.annotation\jakarta.code.annotation-api\1.3.5\jakarta.code.annotation-api-1.3.5.jar;
        // D:\congerfei\mavenrepository\org\yaml\snakeyaml\1.25\snakeyaml-1.25.jar;
        // D:\congerfei\mavenrepository\org\springframework\boot\spring-boot-starter-json\2.2.4.RELEASE\spring-boot-starter-json-2.2.4.RELEASE.jar;D:\congerfei\mavenrepository\com\fasterxml\jackson\core\jackson-databind\2.10.2\jackson-databind-2.10.2.jar;D:\congerfei\mavenrepository\com\fasterxml\jackson\core\jackson-annotations\2.10.2\jackson-annotations-2.10.2.jar;D:\congerfei\mavenrepository\com\fasterxml\jackson\core\jackson-core\2.10.2\jackson-core-2.10.2.jar;D:\congerfei\mavenrepository\com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.10.2\jackson-datatype-jdk8-2.10.2.jar;D:\congerfei\mavenrepository\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.10.2\jackson-datatype-jsr310-2.10.2.jar;D:\congerfei\mavenrepository\com\fasterxml\jackson\module\jackson-module-parameter-names\2.10.2\jackson-module-parameter-names-2.10.2.jar;D:\congerfei\mavenrepository\org\springframework\boot\spring-boot-starter-tomcat\2.2.4.RELEASE\spring-boot-starter-tomcat-2.2.4.RELEASE.jar;D:\congerfei\mavenrepository\org\apache\tomcat\embed\tomcat-embed-core\9.0.30\tomcat-embed-core-9.0.30.jar;D:\congerfei\mavenrepository\org\apache\tomcat\embed\tomcat-embed-el\9.0.30\tomcat-embed-el-9.0.30.jar;D:\congerfei\mavenrepository\org\apache\tomcat\embed\tomcat-embed-websocket\9.0.30\tomcat-embed-websocket-9.0.30.jar;D:\congerfei\mavenrepository\org\springframework\boot\spring-boot-starter-validation\2.2.4.RELEASE\spring-boot-starter-validation-2.2.4.RELEASE.jar;D:\congerfei\mavenrepository\jakarta\validation\jakarta.validation-api\2.0.2\jakarta.validation-api-2.0.2.jar;D:\congerfei\mavenrepository\org\hibernate\validator\hibernate-validator\6.0.18.Final\hibernate-validator-6.0.18.Final.jar;D:\congerfei\mavenrepository\org\jboss\logging\jboss-logging\3.4.1.Final\jboss-logging-3.4.1.Final.jar;D:\congerfei\mavenrepository\com\fasterxml\classmate\1.5.1\classmate-1.5.1.jar;D:\congerfei\mavenrepository\org\springframework\spring-web\5.2.3.RELEASE\spring-web-5.2.3.RELEASE.jar;D:\congerfei\mavenrepository\org\springframework\spring-beans\5.2.3.RELEASE\spring-beans-5.2.3.RELEASE.jar;D:\congerfei\mavenrepository\org\springframework\spring-webmvc\5.2.3.RELEASE\spring-webmvc-5.2.3.RELEASE.jar;D:\congerfei\mavenrepository\org\springframework\spring-aop\5.2.3.RELEASE\spring-aop-5.2.3.RELEASE.jar;D:\congerfei\mavenrepository\org\springframework\spring-context\5.2.3.RELEASE\spring-context-5.2.3.RELEASE.jar;D:\congerfei\mavenrepository\org\springframework\spring-expression\5.2.3.RELEASE\spring-expression-5.2.3.RELEASE.jar;D:\congerfei\mavenrepository\org\slf4j\slf4j-api\1.7.30\slf4j-api-1.7.30.jar;D:\congerfei\mavenrepository\org\springframework\spring-core\5.2.3.RELEASE\spring-core-5.2.3.RELEASE.jar;D:\congerfei\mavenrepository\org\springframework\spring-jcl\5.2.3.RELEASE\spring-jcl-5.2.3.RELEASE.jar;D:\JetBrains\IntelliJ IDEA 2020.2.3\lib\idea_rt.jar



    }



}
