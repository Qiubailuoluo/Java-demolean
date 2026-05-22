# 本地开发端口表

联调时按此表分配端口，避免冲突。阶段二 `application.yml` 应与下表一致。

| moduleId | 端口 | 说明 |
|------------|------|------|
| `sc-eureka-server` | 8761 | Eureka 注册中心 |
| `sc-eureka-client` | 8081 | 注册到 Eureka 的示例服务 |
| `sc-config-server` | 8888 | 配置中心 |
| `sc-config-client` | 8082 | 配置客户端 |
| `sc-feign-provider` | 8083 | Feign 提供方 |
| `sc-feign-consumer` | 8084 | Feign 消费方 |
| `sc-gateway` | 9000 | API 网关对外入口 |
| `sc-loadbalancer-demo` | 8085 | 负载均衡演示 |
| `sc-resilience4j` | 8086 | 熔断演示 |
| `sc-sleuth-zipkin` | 8087 | 链路追踪示例服务 |
| Zipkin Server | 9411 | 需本地 Docker 或独立 jar |
| RabbitMQ | 5672 | 消息队列（可选） |
| `sc-rabbitmq-demo` | 8088 | 消息演示应用 |

## 启动顺序建议

1. 基础设施：Zipkin（808 篇）、RabbitMQ（09 篇，可选）
2. `sc-eureka-server`
3. `sc-config-server` → `sc-config-client`
4. `sc-feign-provider` → `sc-feign-consumer`
5. `sc-gateway`（路由到已注册服务）
6. 其余单模块可按文档独立启动

## 健康检查

```bash
curl http://localhost:8761/
curl http://localhost:9000/actuator/health
```
