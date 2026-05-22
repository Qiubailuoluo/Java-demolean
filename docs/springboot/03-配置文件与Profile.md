# 配置文件与 Profile

## 元信息

| 项 | 值 |
|----|-----|
| 板块 | springboot |
| 难度 | 入门 |
| 预估时长 | 2 小时 |
| 前置 | [02-IoC与DI](02-IoC与DI.md) |

## 学习目标

- [ ] 使用 `application.yml` / `application-{profile}.yml`
- [ ] 通过 `@Value` 与 `@ConfigurationProperties` 绑定配置
- [ ] 激活 `dev`/`prod` Profile 并观察差异
- [ ] 了解配置优先级（命令行 > profile 文件 > 默认）

## 核心概念

### 定义

外部化配置将环境相关参数移出代码。`@ConfigurationProperties` 类型安全绑定前缀属性，适合多字段配置类。

### 常见误区

- 在 prod 将敏感信息明文写入仓库（应使用环境变量或密钥管理）
- `@Value` 散落各处难以维护
- Profile 名称拼写错误导致默认配置静默生效

## 关键 API / 注解

| 名称 | 说明 |
|------|------|
| `@ConfigurationProperties` | 批量绑定 |
| `@Profile` | 环境 Bean |
| `spring.profiles.active` | 激活 Profile |

## 子项目规格

| 字段 | 值 |
|------|-----|
| **moduleId** | `sb-03-config-profile` |
| **path** | `springboot/sb-03-config-profile/` |
| **entry** | `com.lean.config.ConfigProfileApplication` |

### 包结构

| 类 | 说明 |
|----|------|
| `AppProperties` | `@ConfigurationProperties(prefix="app")` |
| `InfoController` | `GET /info` 返回 `app.welcome` |

### application.yml

```yaml
app:
  welcome: "default welcome"
```

### application-dev.yml

```yaml
app:
  welcome: "dev welcome"
```

### 运行与验证

```bash
cd springboot/sb-03-config-profile
mvn spring-boot:run -Dspring-boot.run.arguments=--spring.profiles.active=dev
curl http://localhost:8080/info
```

**期望：** JSON 含 `dev welcome`

## 练习

1. 用环境变量 `APP_WELCOME` 覆盖（`app.welcome`  relaxed binding）。
2. 添加 `@Validated` 与 `@NotBlank` 校验配置项。

## 参考资料

- [Externalized Configuration](https://docs.spring.io/spring-boot/docs/3.2.x/reference/html/features.html#features.external-config)
