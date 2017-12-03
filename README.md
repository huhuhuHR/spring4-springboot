# 读：java EE 开发的颠覆者-spring Boot实战
### spring
###### Core Container
* Spring-Core:核心工具类
* Spring-Beans:Spring定义Bean的支持
* Spring-Context:运行时Spring容器
* Spring-Context-Support:Spring容器对第三方包的集成支持
* Spring-Expression:使用表达式语言在运行时查询和操作对象
###### Aop
* Spring-Aop:基于代理的AOP支持
* Spring-Aspects:基于AspectJ的AOP支持
###### Messaging
* Spring-Messaging:对消息架构和协议的支持
###### Web
* Spring-Web:提供基础的Web集成的功能，在Web项目中提供Spring的容器
* Spring-WebMvc:提供基于Servlet的Spring MVC
* spring-WebSocket:提供WebSocket功能
* Spring-webmvc-Portlet:提供Portlet环境支持
###### Data Access
* spring-JDBC：提供以JDBC访问数据库的支持
* spring-TX：提供编程式和声明式的事务支持
* spring-ORM：提供对对象/关系映射技术的支持
* spring-JMS：提供对JMS的支持
#### maven运作方式
    maven会自动根据dependency中的依赖配置，直接通过互联网在maven中心库下载依赖包到本地仓库。

### spring框架四大原则：
    1）使用POJO进行轻量级和最小侵入式开发
    2）通过依赖注入和基于借口编程实现松耦合
    3）通过AOP和默认习惯进行声明式编程
    4）使用AOP和模版减少模式化代码
### 依赖注入
    容器负责创建对象和维护对象间的依赖关系，而不是通过对象本身负责自己的创建和解决自己的依赖
### 依赖的目的
    解耦，体现"组合"的概念
### Spring Ioc容器
    负责创建bean
### 声明bean注解
* @Component 组件，没有明确的角色
* @Service 在业务逻辑层
* @Repository 在数据访问层
* @Controller 在展现层
### 注入bean，一般情况下通用
* @Autowired
* @Inject
* @Resource
### oop不足
    类继承只能为单继承，阻止更多行为添加到一组类上。
### AOP
    AOP目的就是解耦，让一组类共享相同的行为。
### Spring支持AspectJ的注解式切面编程
1.使用@Aspect声明是一个切面
2.使用@After,@Before,@Around,可直接将拦截规则(切点)作为参数。
3.其中@After,@Before,@Around参数的拦截规则为起点(PointCut)
4.其中符合条件的每一个被拦截处为连接点(JoinPoint)
