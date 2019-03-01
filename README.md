## 前言  
Spring boot + Spring cloud实现微服务

## 项目说明  
服务基于idea、jdk8 、Maven 、spring cloud Camden.SR7、docker、centos 7开发实现  
启动顺序（建议run dashboard)：  
服务发现(diccovery):http://localhost:8761/  
网关(gateway):http://localhost:8041/routes  
配置(config):  
监控追踪(zipkin):http://localhost:9411/  
Hystrix监控(hystrix):http://localhost:8030/hystrix  
用户服务(user):http://localhost:9191/user/hello  
订单服务(order):http://localhost:9092/order/hello  

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
基于过滤器实现的路由:http://localhost:8041/app-user/user/hello
查看服务端点：http://localhost:8041/routes
简化配置的访问方式(yml配置)：http://localhost:8041/order/order/hello
Zuul的安全与Header
Zuul的过滤器生命周期：pre、route、post、error

为了方便各个服务的配置文件统一管理，实时更新需配置中心：
通过git服务器进行管理
configClient(app-user等)--->configServer(infra-config)--->git
此项目使用github托管配置文件(真实环境建议搭建私服)，通过配置钩子、以及activeMq通知各服务刷新配置文件

Sleth
Springboot Actuator实现微服务监控，Hystrix command可视化监控，确认系统瓶颈
整合分布式追踪组件ELK(非常流行的基于日志的分析系统)
整合Twitter的分布式追踪系统Zipkin(提供友好的界面)




# 友情链接
JDK:https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html  
JCE:https://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html  
PostMan:https://www.getpostman.com/downloads/  
Maven:http://maven.apache.org/download.cgi  
github:https://github.com/  
git:https://git-scm.com/downloads  
idea:http://www.jetbrains.com/idea/  
redis:https://redis.io/download  
mysql:https://dev.mysql.com/downloads/  
activeMq:http://activemq.apache.org/download.html  
Vmware:https://my.vmware.com/cn/web/vmware/info/slug/desktop_end_user_computing/vmware_workstation_pro/15_0  
centos:https://www.centos.org/download/  
xshell:https://xshell.en.softonic.com/  





