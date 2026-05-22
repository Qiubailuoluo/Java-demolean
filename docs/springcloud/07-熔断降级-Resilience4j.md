# 熔断降级 Resilience4j

## 元信息

| 项 | 值 |
|----|-----|
| 板块 | springcloud |
| 难度 | 进阶 |
| 预估时长 | 4 小时 |
| 前置 | [04-OpenFeign](04-OpenFeign声明式调用.md) |

## 学习目标

- [ ] 集成 Resilience4j 熔断器
- [ ] 模拟慢调用/失败触发熔断
- [ ] 配置 fallback 返回降级数据
- [ ] 了解半开状态恢复机制

## 核心概念

### 定义

熔断器防止故障扩散：失败率超阈值则快速失败，一段时间后试探恢复。Resilience4j 是 Spring Cloud 3 常用实现。

### 常见误区

- 把 fallback 当作正常业务路径
- 熔断阈值过小导致误熔断
- 与重试叠加造成风暴（需协调配置）

## 关键配置

```yaml
resilience4j:
  circuitbreaker:
    instances:
      remoteService:
        slidingWindowSize: 10
        failureRateThreshold: 50
```

## 子项目规格

| 字段 | 值 |
|------|-----|
| **moduleId** | `sc-resilience4j` |
| **path** | `springcloud/sc-resilience4j/` |
| **port** | 8086 |
| **entry** | `com.lean.resilience.ResilienceApplication` |

### Maven

```xml
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-circuitbreaker-resilience4j</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

### 包结构

| 类 | 说明 |
|----|------|
| `UnstableService` | `fail=true` 时抛异常 |
| `ResilientController` | `@CircuitBreaker` + fallback |
| `GET /demo?fail=true` | 触发失败 |

### 运行与验证

```bash
cd springcloud/sc-resilience4j
mvn spring-boot:run
# 连续失败触发熔断
for /L %i in (1,1,15) do curl "http://localhost:8086/demo?fail=true"
curl http://localhost:8086/demo?fail=false
```

观察 fallback 响应与日志中熔断状态变化。

## 练习

1. 结合 Feign + Resilience4j 保护远程调用。
2. 配置 `TimeLimiter` 限制 2 秒超时。

## 参考资料

- [Spring Cloud Circuit Breaker](https://docs.spring.io/spring-cloud-commons/docs/current/reference/html/#circuit-breaker)
- [Resilience4j](https://resilience4j.readme.io/docs)
