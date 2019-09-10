# bmall-dubbo

### bmall-api 
服务Api
### bamll-service-provider
服务提供者
### bamll-order-comsumer
服务消费者

#### dubbo管理控制台dubbo-admin安装
1.源码下载
Apache/dubbo-admin  
```$xslt
git clone git@github.com:apache/dubbo-admin.git)
```
2.切换到dubbo-admin模块下，进行打包
```$xslt
执行 mvn clean compile 进行编译，编译成功后执行 mvn clean package 来进行打包
```
3.启动Zookeeper

dubbo使用Zookeeper作为注册中心

4.运行打好的jar包

进入target目录下，执行
```$xslt
java -jar .\dubbo-admin-0.0.1-SNAPSHOT.jar
```
5.访问[dubbo管理页面](http://127.0.0.1:7001/)

在dubbo-admin\src\main\webapp\WEB-INF文件夹下的dubbo.properties文件，
将dubbo.registry.address修改成启动了zookeeper注册中心的主机IP和端口即可，默认如下（不需要改动）

```$xslt
server.port=7001
spring.velocity.cache=false
spring.velocity.charset=UTF-8
spring.velocity.layout-url=/templates/default.vm
spring.messages.fallback-to-system-locale=false
spring.messages.basename=i18n/message
spring.root.password=root
spring.guest.password=guest

dubbo.registry.address=zookeeper://127.0.0.1:2181
```
文件中

spring.root.password=root
spring.guest.password=guest

两行代表了登录dubbo台的密码，分别是root和guest用户，对应密码也是root和guest

启动bamll-service-provider和bamll-order-comsumer模块就可以看到相关的提供者和消费者

[项目地址](https://github.com/sdisk/bmall-dubbo.git)

[dubbo文档](http://dubbo.apache.org/zh-cn/docs/user/quick-start.html)