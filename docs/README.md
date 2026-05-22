# JavaLean 文档索引

> 完整 `moduleId` 对照表见文末。学习顺序见 [00-学习路线.md](00-学习路线.md)。

## 本机环境配置

| 文档 | 说明 |
|------|------|
| [environment/README.md](environment/README.md) | 环境文档索引 |
| [environment/jdk.md](environment/jdk.md) | JDK 17（Microsoft OpenJDK） |
| [environment/maven.md](environment/maven.md) | Maven 3.6.3 路径与本地仓库 |
| [environment/mysql.md](environment/mysql.md) | MySQL localhost:3306 |
| [environment/redis.md](environment/redis.md) | Redis localhost:6379 |

## Java 编程基础

| 序号 | 文档 | moduleId |
|------|------|----------|
| 01 | [变量与数据类型](java-basics/01-变量与数据类型.md) | `jb-01-variables` |
| 02 | [流程控制](java-basics/02-流程控制.md) | `jb-02-control-flow` |
| 03 | [面向对象](java-basics/03-面向对象.md) | `jb-03-oop` |
| 04 | [异常机制](java-basics/04-异常机制.md) | `jb-04-exception` |
| 05 | [集合框架](java-basics/05-集合框架.md) | `jb-05-collections` |
| 06 | [泛型](java-basics/06-泛型.md) | `jb-06-generics` |
| 07 | [IO 与 NIO 入门](java-basics/07-IO与NIO入门.md) | `jb-07-io` |
| 08 | [多线程](java-basics/08-多线程.md) | `jb-08-threading` |
| 09 | [Lambda 与 Stream](java-basics/09-Lambda与Stream.md) | `jb-09-stream` |
| 10 | [JDBC 基础](java-basics/10-JDBC基础.md) | `jb-10-jdbc` |
| 11 | [反射与注解](java-basics/11-反射与注解.md) | `jb-11-reflection` |
| 12 | [Java 8～17 新特性速览](java-basics/12-Java8-17新特性速览.md) | `jb-12-modern-java` |

## Spring Boot

| 序号 | 文档 | moduleId |
|------|------|----------|
| 01 | [项目结构与自动配置](springboot/01-项目结构与自动配置.md) | `sb-01-starter` |
| 02 | [IoC 与 DI](springboot/02-IoC与DI.md) | `sb-02-ioc-di` |
| 03 | [配置文件与 Profile](springboot/03-配置文件与Profile.md) | `sb-03-config-profile` |
| 04 | [Spring MVC 与 REST](springboot/04-SpringMVC与REST.md) | `sb-04-rest-api` |
| 05 | [数据访问 JPA](springboot/05-数据访问JPA.md) | `sb-05-jpa` |
| 06 | [MyBatis 入门](springboot/06-MyBatis入门.md) | `sb-06-mybatis` |
| 07 | [AOP](springboot/07-AOP.md) | `sb-07-aop` |
| 08 | [全局异常处理](springboot/08-全局异常处理.md) | `sb-08-global-exception` |
| 09 | [拦截器与过滤器](springboot/09-拦截器与过滤器.md) | `sb-09-interceptor-filter` |
| 10 | [参数校验](springboot/10-参数校验.md) | `sb-10-validation` |
| 11 | [日志与 Actuator](springboot/11-日志与Actuator.md) | `sb-11-logging-actuator` |
| 12 | [定时任务](springboot/12-定时任务.md) | `sb-12-scheduling` |
| 13 | [Spring Security 基础](springboot/13-SpringSecurity基础.md) | `sb-13-security-basic` |
| 14 | [单元与集成测试](springboot/14-单元与集成测试.md) | `sb-14-testing` |

## Spring Cloud

| 序号 | 文档 | moduleId |
|------|------|----------|
| 01 | [微服务架构概览](springcloud/01-微服务架构概览.md) | — |
| 02 | [服务注册与发现 Eureka](springcloud/02-服务注册与发现-Eureka.md) | `sc-eureka-server`、`sc-eureka-client` |
| 03 | [配置中心](springcloud/03-配置中心.md) | `sc-config-server`、`sc-config-client` |
| 04 | [OpenFeign 声明式调用](springcloud/04-OpenFeign声明式调用.md) | `sc-feign-provider`、`sc-feign-consumer` |
| 05 | [Gateway 网关](springcloud/05-Gateway网关.md) | `sc-gateway` |
| 06 | [负载均衡](springcloud/06-负载均衡.md) | `sc-loadbalancer-demo` |
| 07 | [熔断降级 Resilience4j](springcloud/07-熔断降级-Resilience4j.md) | `sc-resilience4j` |
| 08 | [分布式链路追踪](springcloud/08-分布式链路追踪.md) | `sc-sleuth-zipkin` |
| 09 | [消息驱动（可选）](springcloud/09-消息驱动-可选.md) | `sc-rabbitmq-demo` |
| 10 | [分布式事务概览](springcloud/10-分布式事务概览.md) | — |
| 11 | [Nacos 替代方案速览](springcloud/11-Nacos替代方案速览.md) | — |
| 12 | [综合演练迷你电商](springcloud/12-综合演练-迷你电商.md) | 多模块，见 [_labs](springcloud/_labs/mini-mall-lab.md) |

### 联调说明

- [本地开发端口表](springcloud/_labs/local-dev-ports.md)
- [迷你电商综合演练](springcloud/_labs/mini-mall-lab.md)

## moduleId 与目录对照表

| moduleId | 阶段二路径 |
|----------|------------|
| `jb-01-variables` | `java-basics/jb-01-variables/` |
| `jb-02-control-flow` | `java-basics/jb-02-control-flow/` |
| `jb-03-oop` | `java-basics/jb-03-oop/` |
| `jb-04-exception` | `java-basics/jb-04-exception/` |
| `jb-05-collections` | `java-basics/jb-05-collections/` |
| `jb-06-generics` | `java-basics/jb-06-generics/` |
| `jb-07-io` | `java-basics/jb-07-io/` |
| `jb-08-threading` | `java-basics/jb-08-threading/` |
| `jb-09-stream` | `java-basics/jb-09-stream/` |
| `jb-10-jdbc` | `java-basics/jb-10-jdbc/` |
| `jb-11-reflection` | `java-basics/jb-11-reflection/` |
| `jb-12-modern-java` | `java-basics/jb-12-modern-java/` |
| `sb-01-starter` | `springboot/sb-01-starter/` |
| `sb-02-ioc-di` | `springboot/sb-02-ioc-di/` |
| `sb-03-config-profile` | `springboot/sb-03-config-profile/` |
| `sb-04-rest-api` | `springboot/sb-04-rest-api/` |
| `sb-05-jpa` | `springboot/sb-05-jpa/` |
| `sb-06-mybatis` | `springboot/sb-06-mybatis/` |
| `sb-07-aop` | `springboot/sb-07-aop/` |
| `sb-08-global-exception` | `springboot/sb-08-global-exception/` |
| `sb-09-interceptor-filter` | `springboot/sb-09-interceptor-filter/` |
| `sb-10-validation` | `springboot/sb-10-validation/` |
| `sb-11-logging-actuator` | `springboot/sb-11-logging-actuator/` |
| `sb-12-scheduling` | `springboot/sb-12-scheduling/` |
| `sb-13-security-basic` | `springboot/sb-13-security-basic/` |
| `sb-14-testing` | `springboot/sb-14-testing/` |
| `sc-eureka-server` | `springcloud/sc-eureka-server/` |
| `sc-eureka-client` | `springcloud/sc-eureka-client/` |
| `sc-config-server` | `springcloud/sc-config-server/` |
| `sc-config-client` | `springcloud/sc-config-client/` |
| `sc-feign-provider` | `springcloud/sc-feign-provider/` |
| `sc-feign-consumer` | `springcloud/sc-feign-consumer/` |
| `sc-gateway` | `springcloud/sc-gateway/` |
| `sc-loadbalancer-demo` | `springcloud/sc-loadbalancer-demo/` |
| `sc-resilience4j` | `springcloud/sc-resilience4j/` |
| `sc-sleuth-zipkin` | `springcloud/sc-sleuth-zipkin/` |
| `sc-rabbitmq-demo` | `springcloud/sc-rabbitmq-demo/` |

## 其他

- [知识点文档模板](templates/知识点文档模板.md)
