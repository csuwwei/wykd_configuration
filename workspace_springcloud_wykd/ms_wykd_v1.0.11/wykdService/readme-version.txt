1.0.14版本
	(1)netty

1.0.13版本：
	(1)jdk1.8新特性

1.0.12版本：
	(1)使用jedis ,luttue 使用redis
	(2)用redis实现消息队列
	(3)用redis实现session共享
	(4)用redis实现分布式锁

1.0.11版本：
	(1)bootstrap
	(2)vue
	(3)rabbitMq的三种路由方式
	(4)mybatis实现分页效果 PageHelper ,增删改查一套
	(5)Rest访问传参方式，一套
	(2)提供页面访问，实现session方式的注册，登录，sso
	(2)实现outh2

1.0.11版本
	(1)SSO [20190418]
	(2)CAS [20190419]
	(3)JWT
	
1.0.10版本：[20190416]
	(1)IO流	

1.0.9版本：[20190415]
	(1)实现security,jwt[20190416]
	
1.0.8版本：[20190414]
	(1)多线程编程 Callable
	(2)线程池	

1.0.7版本：[20190413]
	(1)user微服务引入myBatis,durid [OK20190410]
	(2)redis服务安装到阿里云服务器上，连接使用,实现本地连接服务器 [OK20190413]
	(3)在阿里云服务器安装mysql数据库  OK  实现本地连接服务器[OK20190413]
	(4)将rabbitMQ的服务，  OK   实现本地连接服务器[OK20190413]
	(6)实现zuul的routes端点的访问  	[OK20190410]
	(7)实现事务，全局异常处理 , LOGGER日志添加  [OK20190414]

1.0.6版本:[20190409]
	(1)config,chongwu引入Spring Config Server

1.0.5版本:[20190408]
	(1)jiazhuang引入Redis

1.0.4版本:[20190407]
	(1)yundong引入rabbitMQ
	(2)shenghuo微服务引入 rabbitMQ，实现yundong微服务发送消息，shenghuo微服务接收消息

1.0.3版本:[20190405]
	(1)meishi引入Feign,引入Hystrix
	(2)movie引入Ribbon,引入Hystrix
	(3)整理代码，优化了访问链接.
		

1.0.2版本:[20190402]
	(1)引入Zuul
		http://localhost:8001/movie/index
		http://localhost:8001/user/wykd-user/index
	(2)网关与restTemplate结合使用
		网关访问：http://localhost:8001/movie/userInfo
		单边访问1：http://localhost:8012/userInfo
		单边访问2：http://localhost:8003/wykd-user/index
	(3)movie微服务引入ribbon  (http://localhost:8012/userInfo)	

1.0.1版本：[20190401]
	(1)增加Eureka服务端微服务,Eureka访问地址:http://localhost:8002/
	(2)将用户微服务，电影微服务注册到Eureka中
	

1.0.0版本:[20190328]
	(1)借助【https://start.spring.io】，从0开始搭建了2个spring boot项目，并成功启动。
		访问地址：http://localhost:8003/wykd-user/index
	(2)实现了maven父子项目统一管理
	(3)实现了电影微服务使用RestTemplate调用用户微服务
		访问地址：http://localhost:8012/userInfo
	