## 笔记
1.利用github的oAuth apps实现连接github账户的用户登录功能
具体步骤参照github中setings里面的developer settings里面的oAuth apps里面的操作流程
1.1 其中需要用到json转对象和对象转json的jar包Fastjson
1.2 需要再程序中发送携带的参数的get,post请求需要用到okhttp 
1.3 当需要多个参数时，可以把这些参数封装成一个对象
1.4 可以用配置文件中读取变量的属性值  例如 @Value("${github.client.id}")

2.数据用到了容易上手的H2数据库 导入相关jar包即可使用
Add the h2*.jar to the classpath (H2 does not have any dependencies)
Use the JDBC driver class: org.h2.Driver
The database URL jdbc:h2:~/test opens the database test in your user home directory
A new database is automatically created

##工具

flyway :数据库版本控制工具

##社区