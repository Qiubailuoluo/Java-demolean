# OpenFeign 声明式调用

## 元信息

| 项 | 值 |
|----|-----|
| 板块 | springcloud |
| 难度 | 进阶 |
| 预估时长 | 4 小时 |
| 前置 | [02-服务注册与发现-Eureka](02-服务注册与发现-Eureka.md) |

## 学习目标

- [ ] 声明 Feign 接口映射 REST API
- [ ] 结合 Eureka 按服务名调用
- [ ] 理解 Feign 与 RestTemplate 区别
- [ ] 完成 consumer 调用 provider

## 核心概念

### 定义

OpenFeign 用 JDK 动态代理将 HTTP 调用封装为接口方法，集成负载均衡与熔断（需额外依赖）。

### 常见误区

- `@FeignClient` name 与 provider `spring.application.name` 不一致
- GET 请求使用 `@RequestBody`
- 未启动注册中心导致 `Load balancer does not contain an instance`

## 关键注解

| 名称 | 说明 |
|------|------|
| `@EnableFeignClients` | 启用 Feign |
| `@FeignClient` | 声明客户端 |
| `@GetMapping` 等 | 映射路径 |

## 子项目规格

### sc-feign-provider（主演示：提供 API）

| 字段 | 值 |
|------|-----|
| **path** | `springcloud/sc-feign-provider/` |
| **port** | 8083 |
| **entry** | `com.lean.feign.ProviderApplication` |
| **spring.application.name** | `product-service` |

接口：`GET /products/{id}` → `{"id":1,"name":"Book"}`

依赖：`eureka-client`、`spring-boot-starter-web`

### sc-feign-consumer（配套：调用方）

| 字段 | 值 |
|------|-----|
| **path** | `springcloud/sc-feign-consumer/` |
| **port** | 8084 |
| **entry** | `com.lean.feign.ConsumerApplication` |

```java
@FeignClient(name = "product-service")
public interface ProductClient {
    @GetMapping("/products/{id}")
    Product get(@PathVariable("id") Long id);
}
```

`GET /orders/{productId}` 内部 Feign 查商品再返回订单 DTO。

依赖：`spring-cloud-starter-openfeign`、`eureka-client`、`web`

### 运行与验证

```bash
# 需 Eureka 已启动（02 篇）
cd springcloud/sc-eureka-server && mvn spring-boot:run
cd springcloud/sc-feign-provider && mvn spring-boot:run
cd springcloud/sc-feign-consumer && mvn spring-boot:run
curl http://localhost:8084/orders/1
```

## 练习

1. 为 Feign 配置超时与重试（了解即可）。
2. 增加 Fallback 类（与 07 篇 Resilience4j 结合）。

## 参考资料

- [Spring Cloud OpenFeign](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)
