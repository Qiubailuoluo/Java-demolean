# 日志与 Actuator

## 元信息

| 项 | 值 |
|----|-----|
| 板块 | springboot |
| 难度 | 进阶 |
| 预估时长 | 2 小时 |
| 前置 | [01-项目结构与自动配置](01-项目结构与自动配置.md) |

## 学习目标

- [ ] 配置 Logback 日志级别与格式
- [ ] 使用 SLF4J 占位符正确打日志
- [ ] 启用 Actuator 并暴露 `health`、`info`
- [ ] 了解生产环境端点暴露安全策略

## 核心概念

### 定义

Spring Boot 默认 Logback。Actuator 提供生产就绪端点监控应用健康与指标。

### 常见误区

- 生产暴露全部 Actuator 端点且无鉴权
- 字符串拼接日志：`log.debug("id=" + id)` 应使用 `{}`
- 将敏感信息写入 info 日志

## 关键 API / 注解

| 名称 | 说明 |
|------|------|
| `management.endpoints.web.exposure.include` | 暴露端点 |
| `/actuator/health` | 健康检查 |
| `logging.level.*` | 包级别 |

## 子项目规格

| 字段 | 值 |
|------|-----|
| **moduleId** | `sb-11-logging-actuator` |
| **path** | `springboot/sb-11-logging-actuator/` |
| **entry** | `com.lean.actuator.LoggingActuatorApplication` |

### Maven 依赖

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

### application.yml

```yaml
management:
  endpoints:
    web:
      exposure:
        include: health,info
logging:
  level:
    com.lean: DEBUG
```

### 包结构

| 类 | 说明 |
|----|------|
| `DemoService` | 打 debug/info 日志 |
| `DemoController` | 触发服务调用 |

### 运行与验证

```bash
cd springboot/sb-11-logging-actuator
mvn spring-boot:run
curl http://localhost:8080/actuator/health
curl http://localhost:8080/demo
```

## 练习

1. 在 `logback-spring.xml` 中按 profile 分文件输出。
2. 自定义 `HealthIndicator` 检查磁盘空间（模拟）。

## 参考资料

- [Actuator](https://docs.spring.io/spring-boot/docs/3.2.x/reference/html/actuator.html)
