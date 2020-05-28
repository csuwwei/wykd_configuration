SpringCloud：		9001 - 9050
redis:   			9051 - 9080  
rabbitMq: 			9081 - 9999
basic:   			8001 - 8030
sso:  				8031 - 8040
	
端口对照：
	zuul微服务：	8000   	zuul 
	Eureka微服务：	8010	eureka
	config微服务	8030	spring cloud config server
	chongwu微服务   9060    spring cloud config client
	user微服务:	9000	mybatis druid  jwt  security 
	movie微服务：	9010	ribbon+Hystrix
	meishi微服务：	9020	feign+Hystrix ，多线程Callable，线程池
	
	yundong微服务：9030	rabbitMQ sender 
	shenguho微服务：9040	rabbitMQ receiver
	
	jiazhuang微服务：9050  redis
	
	basic微服务	9070	IO流  jdk8新特性
	
	jiadian			sso server
	kongtiao   		sso client
	dianshi   		sso client
	bingxiang    	cas client
	
	
相关测试连接：
http://localhost:8010/wykd-eureka/
http://localhost:9000/wykd-user/userService/index
http://localhost:9020/wykd-meishi/meishiService/index
http://localhost:9010/wykd-movie/movieService/index
http://localhost:9010/wykd-movie/movieService/restWykdUserHello
http://localhost:9020/wykd-meishi/meishiService/feignWykdUserHello
http://localhost:9020/wykd-meishi/meishiService/feignUserInfoByUserId?userId=100
http://localhost:8000/wykd-zuul/meishi/services/wykd-meishi/meishiService/feignWykdUserHello
http://localhost:8000/wykd-zuul/user/services/wykd-user/userService/index	

多线程测试：
http://localhost:9020/wykd-meishi/meishiThreadService/feignWykdUserThread
线程池测试：
http://localhost:9020/wykd-meishi/meishiThreadService/feignWykdUserThreadPool

sso客户端访问链接：
http://localhost:9022/wykd-kongtiao/kongtiaoRedirectService/main