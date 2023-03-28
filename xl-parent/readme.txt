0.新建父项目xl-parent,团队名称统一用com.xl，每个项目的包名以com.xl.项目名 开始，并使用maven的形式创建如下项目，并实现继承关系
（不用使用idea创建springboot的形式创建项目骨架，它只会以springboot父项目作为默认父项目，与我们的设计思想不符合）
1.springboot1-start 用于测试启动
2.springboot2-test，其他的测试项目丢进去
可以新建其他子工程
3.springboot3-admin 注册中心，也就是整个项目的心脏
4.以后添加其他项目看其重要程度，看是与springboot1-start同级  还是作为springboot2-test的子项目
5.springboot4-config 测试分布式配置


--数据库配置信息
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://192.168.137.100/xl?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC
jdbc.username=root
jdbc.password=123456

如果有mapper文件或者其他配置信息在java目录下面，请添加如下信息，不是xml文件的请略作修改
<build>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
        </resources>
</build>



记住一些快捷键
Alt+数字  可以调用边框
Ctrl+h 查看当前类继承关系
ctrl+shift+r 替换

1.Ø Top #1智能补全：Ctrl+Shift+Space
2.Ø Top #1自我修复：Alt+Enter
3.Ø Top #1重构一切：Ctrl+Shift+Alt+T

1.Ø Top #10切来切去：Ctrl+Tab
2.Ø Top #9选你所想【选中上下文相关联代码】：Ctrl+W
3.Ø Top #8代码生成：Template/Postfix +Tab
4.Ø Top #7发号施令：Ctrl+Shift+A
5.Ø Top #6无处藏身：Shift+Shift
6.Ø Top #5自动完成：Ctrl+Shift+Enter
7.Ø Top #4创造万物：Alt+Insert
