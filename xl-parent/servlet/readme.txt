1.servlet-01  通过继承GenericServlet的类来直接部署到tomcat上，并成功访问  com.xl.MyService中有详细的操作步骤，发现手动部署太麻烦了
2.servlet-02-maven通过maven来部署，新建maven项目，使用骨架maven-archetype-webapp来新建，使用骨架来创建项目有点慢,实现的是Servlet接口
3.注意自己的java环境，如果使用骨架搭建不能新建java文件，不要乱指定java环境，要保证java下的代码能正常打包到tomcat中，
   新建项目后只有src/main  然后新建java文件夹，如果能新建class则不用管,如果不能则需要指定java环境 ，可以到Project Structure中及时调整

   更深层次的了解到编写servlet的映射的理解：
   <!--编写Servlet的映射：我们的写的java程序，但是要通过浏览器访问，而浏览器需要连接web服务器，
     所以要在web服务器中注册我们写的Servlet，还需要给他一个浏览器能够访问的地址-->
4.tomcat日志乱码问题：配置tomcat环境的时候带上  -Dfile.encoding=utf-8 参数

5.servlet_03_ServletContextListener  测试一下实现httpServlet 以及全局监听器：我部署了2个项目，
    发现监听器是在所有的servlet初始化前创建的，在所有的servlet销毁后关闭的
  <!--web.xml中的文件是又顺序的不能乱排序，发现把listener放servlet后就文件报错了-->
可以进阶了解下ContextLoaderListener
当Servlet容器启动时，ServletContext对象被初始化，然后Servlet容器调用web.xml中注册的监听器的
public void contextInitialized(ServletContextEvent event)方法，而在监听器中，调用了this.initWebApplicationContext(event.getServletContext())方法，
在这个方法中实例化了Spring IOC容器。即ApplicationContext对象。
因此，当ServletContext创建时我们可以创建applicationContext对象，当ServletContext销毁时，我们可以销毁applicationContext对象。这样applicationContext就和ServletContext“共生死了”。

6.创建一个servlet-04-jsp   准备集成jsp但是感觉不用写

总结：
Servlet实现方式
实现Servlet接口
继承GenericServelt抽象类（这个类是Servlet接口的一级实现类）
继承HttpServlet抽象类就可以间接的实现Servlet接口（位于javax.servlet.http包中的HttpServlet抽象类继承自GenericServlet类，是Servlet接口的二级实现类）
