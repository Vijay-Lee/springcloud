## 前言  
Spring boot + Spring cloud实现微服务

## 项目说明  
服务基于idea、jdk8 、Maven 、spring cloud Camden.SR7、docker、centos 7开发实现  
# Spring boot  
集成logback日志处理、全局异常处理、Junit单元测试、Web、thymeleaf&&freemarker模板引擎  
数据库采用mysql，数据访问采用Druid连接池，缓存采用Redis  
采用Spring security安全控制  
采用Swagger2构建RESTful API  
# Spring cloud  
采用Eureka作为微服务的注册与发现:http://localhost:8761/
app-order订单服务 app-user用户服务
支持Rest+Ribbon/Feign(eureka已默认集成feign,feign默认集成ribbon)的服务消费与Ribbon客户端负载均衡
通过Hystrix容错断路器（服务调用方）避免雪崩效应，断路器统计失败率，超过某个错误率，断路器打开
actuator进行Hystrix断路器的状态：http://localhost:9092/health
Hystrix监控：localhost:9092/hystrix.stream
Hystrix Dashboard可视化监控 ：http://localhost:8030/hystrix
网关Zuul解决客户端直接与各个微服务通信的问题、统一认证问题、跨域请求问题
基于过滤器实现的路由
提供统一的配置中心Config  
* Docker  
mysql、redis均采用docker安装  
微服务通过jar\war部署、linux服务部署、docker云部署  




