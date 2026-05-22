# 迷你电商综合演练

配合 [12-综合演练-迷你电商.md](../12-综合演练-迷你电商.md)，在本地串联多个 `sc-*` 模块。

## 场景

- **商品服务** `sc-feign-provider`（端口 8083）：`GET /products/{id}`
- **订单服务** `sc-feign-consumer`（端口 8084）：通过 Feign 调用商品服务创建订单
- **注册中心** `sc-eureka-server`（8761）
- **网关** `sc-gateway`（9000）：对外 `GET /mall/products/{id}`

## 启动顺序

```text
1. sc-eureka-server      (8761)
2. sc-feign-provider    (8083)  等待注册成功
3. sc-feign-consumer    (8084)
4. sc-gateway           (9000)  配置路由到 provider
```

## Gateway 路由示例（阶段二配置）

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: product-route
          uri: lb://sc-feign-provider
          predicates:
            - Path=/mall/products/**
          filters:
            - StripPrefix=1
```

## 验证

```bash
curl http://localhost:9000/mall/products/1
curl http://localhost:8084/orders -X POST -H "Content-Type: application/json" -d "{\"productId\":1,\"qty\":2}"
```

## 故障排查

| 现象 | 可能原因 |
|------|----------|
| 503 | 服务未注册或 Gateway `lb://` 服务名不匹配 |
| UnknownHost | 未先启动 Eureka |
| 超时 | Resilience4j 未配置或下游未启动 |

## 扩展

- 将 `sc-config-server` 统一管理各服务 `application.yml`
- 启动 Zipkin 后在 Gateway 与 Consumer 间观察 traceId
