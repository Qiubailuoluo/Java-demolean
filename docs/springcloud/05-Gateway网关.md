# Gateway 网关

## 元信息

| 项 | 值 |
|----|-----|
| 板块 | springcloud |
| 难度 | 进阶 |
| 预估时长 | 3 小时 |
| 前置 | [02-服务注册与发现-Eureka](02-服务注册与发现-Eureka.md)、[04-OpenFeign](04-OpenFeign声明式调用.md) |

## 学习目标

- [ ] 使用 Spring Cloud Gateway 路由到下游服务
- [ ] 配置 `lb://` 与 Eureka 集成
- [ ] 使用 Predicate 与 Filter（StripPrefix）
- [ ] 统一对外入口端口（9000）

## 核心概念

### 定义

API 网关是南北向流量入口，负责路由、鉴权、限流、跨域等。Gateway 基于 WebFlux，非 Servlet Tomcat 阻塞模型。

### 常见误区

- 与 Zuul 1.x 混淆（已维护模式不同）
- 路由 `uri` 写死 IP 失去扩缩容能力
- 大文件上传未调缓冲区导致失败

## 子项目规格

| 字段 | 值 |
|------|-----|
| **moduleId** | `sc-gateway` |
| **path** | `springcloud/sc-gateway/` |
| **port** | 9000 |
| **entry** | `com.lean.gateway.GatewayApplication` |

### Maven

```xml
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

### application.yml

```yaml
server:
  port: 9000
spring:
  application:
    name: sc-gateway
  cloud:
    gateway:
      routes:
        - id: product-service
          uri: lb://product-service
          predicates:
            - Path=/api/products/**
          filters:
            - StripPrefix=1
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

### 运行与验证

前置：Eureka + `sc-feign-provider`（`product-service`）已启动。

```bash
cd springcloud/sc-gateway && mvn spring-boot:run
curl http://localhost:9000/api/products/1
```

## 练习

1. 添加全局 CORS 配置。
2. 增加路由到 `demo-client`（02 篇客户端）。

## 参考资料

- [Spring Cloud Gateway](https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/)
