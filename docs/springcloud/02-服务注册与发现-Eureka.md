# 服务注册与发现 Eureka

## 元信息

| 项 | 值 |
|----|-----|
| 板块 | springcloud |
| 难度 | 进阶 |
| 预估时长 | 4 小时 |
| 前置 | [01-微服务架构概览](01-微服务架构概览.md) |

## 学习目标

- [ ] 搭建 Eureka Server 注册中心
- [ ] 客户端注册并发现服务实例
- [ ] 理解心跳、续约与自我保护模式
- [ ] 通过 Dashboard 查看注册列表

## 核心概念

### 定义

服务注册中心维护实例元数据（IP、端口、健康）。消费者从注册中心拉取列表并实现客户端负载均衡。

### 常见误区

- 开发环境关闭自我保护导致频繁踢实例
- 多网卡注册错误 IP
- 服务名 `spring.application.name` 与 Feign value 不一致

## 关键依赖

```xml
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

BOM 见 [_pom-baseline.md](_pom-baseline.md)。

## 子项目规格

### 模块 A：sc-eureka-server

| 字段 | 值 |
|------|-----|
| **moduleId** | `sc-eureka-server` |
| **path** | `springcloud/sc-eureka-server/` |
| **entry** | `com.lean.eureka.EurekaServerApplication` |
| **port** | 8761 |

#### application.yml

```yaml
server:
  port: 8761
spring:
  application:
    name: sc-eureka-server
eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
```

#### 启动类注解

`@EnableEurekaServer`

### 模块 B：sc-eureka-client

| 字段 | 值 |
|------|-----|
| **moduleId** | `sc-eureka-client` |
| **path** | `springcloud/sc-eureka-client/` |
| **entry** | `com.lean.eureka.EurekaClientApplication` |
| **port** | 8081 |

#### application.yml

```yaml
server:
  port: 8081
spring:
  application:
    name: demo-client
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

#### 演示接口

`GET /hello` → `hello from client`

### 运行与验证

```bash
# 终端 1
cd springcloud/sc-eureka-server && mvn spring-boot:run
# 终端 2
cd springcloud/sc-eureka-client && mvn spring-boot:run
curl http://localhost:8081/hello
```

浏览器打开 `http://localhost:8761`，应看到 `DEMO-CLIENT` 实例。

## 练习

1. 启动第二个 client 实例（改端口 8089）观察负载均衡准备（为 06 篇铺垫）。
2. 阅读 eureka 自我保护日志含义。

## 参考资料

- [Spring Cloud Netflix Eureka](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/)
