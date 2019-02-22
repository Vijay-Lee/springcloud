# 前言  
Spring Boot做为下一代 web 框架，Spring Cloud 作为最新最火的微服务的翘楚  
你还有什么理由拒绝，赶快上幼儿园的车...  

# 项目说明  
服务基于idea、jdk1.8_x86 、Maven 3.2.5 、spring cloud Camden.SR7、docker、centos 7开发实现  
* Spring boot  
集成logback日志处理、全局异常处理、Junit单元测试、Web、thymeleaf&&freemarker模板引擎  
数据库采用mysql，数据访问采用Druid连接池，缓存采用Redis  
采用Spring security安全控制  
采用Swagger2构建RESTful API  
* Spring cloud  
采用Eureka作为微服务的注册与发现(包括自我保护、健康检查、多网卡IP选择、统一用户认证等)  
支持Rest+Ribbon/Feign的服务消费与客户端负载均衡  
采用Zuul网关、Sleuth追踪  
提供统一的配置中心Config  
* Docker  
mysql、redis均采用docker安装  
微服务通过jar\war部署、linux服务部署、docker云部署  

** 欢迎来喷 **


