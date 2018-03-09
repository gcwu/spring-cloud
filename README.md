#### spring-cloud 项目介绍

| 路径 | 功能 | 模块          
| ---------------------  | ------------ | ---------
| /spring-cloud-common   | 公共模块     | 核心，公用代码都写在这里，例如公用的实体，通用工具类等
| /spring-cloud-server   | 服务         | 核心
| /spring-cloud-provider | 提供者       | 核心
| /spring-cloud-consumer | 消费者       | 核心
| /spring-cloud-dashboard| 监控         | 核心
| /spring-cloud-gateway  | zuul网关     | 核心

### 环境操作

### 项目启动
直接右键 run   *Application.java

###  spring-cloud-dashboard 监控平台
    启动后访问 http://localhost:8082/hystrix
    输入消费者访问地址  Single Hystrix App: http://localhost:port/hystrix.stream

### spring security
    项目集成spring security
    目前授权方式：http://localhost:8083/login?username=admin&password=admin
    默认用户名：admin  密码 admin
    现阶段还未接入数据库，默认登录后可或得所有访问权限，后续加入角色





