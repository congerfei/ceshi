mybatis官网 https://mybatis.org/mybatis-3/zh/getting-started.html
1.导包
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.2</version>
</dependency>

2.mybatis关键配置文件  mybatis-config.xml 配置数据库的信息

3. 写工具类生产sqlSession

4.写一个pojo.User  可以使用lombok简写

5.写一个dao   以及 实现的mapper文件

6.记住这个方法 ： UserDao mapper = sqlSession.getMapper(UserDao.class);

