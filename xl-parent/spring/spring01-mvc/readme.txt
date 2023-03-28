springmvc项目
使用maven的web骨架快速创建
和servlet的区别：
将继承HttpServlet换成springmvc的org.springframework.web.servlet.DispatcherServlet

springmvc的步骤
1.web.xml配置servlet（DispatcherServlet），和servletMapping
2.实现controller接口，并在spring的配置文件中进行配置，或者直接使用注解的方式

另外jsp中引入了jstl，需要导入jar包，我们下载的tomcat中有，直接拿来添加进依赖就行了
D:\congerfei\apache-tomcat-8.5.42\webapps\examples\WEB-INF\lib 下的两个包引入依赖即可

视图解析器：无论何种返回值，springMVC最终都会转化为一个ModelAndView对象，然后调用视图解析器进行解析


