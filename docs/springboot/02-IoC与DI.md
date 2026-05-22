# IoC 与 DI

## 元信息

| 项 | 值 |
|----|-----|
| 板块 | springboot |
| 难度 | 入门 |
| 预估时长 | 3 小时 |
| 前置 | [01-项目结构与自动配置](01-项目结构与自动配置.md) |

## 学习目标

- [ ] 理解 IoC 容器与 Bean 生命周期概念
- [ ] 使用 `@Component`、`@Service`、`@Autowired` 注入依赖
- [ ] 区分构造器注入与字段注入（推荐构造器）
- [ ] 了解 `@Configuration` 与 `@Bean`

## 核心概念

### 定义

控制反转将对象创建交给容器；依赖注入通过容器装配协作对象。Spring Boot 默认扫描启动类所在包及子包。

### 常见误区

- 循环依赖在构造器注入下直接失败（需重构）
- 同一接口多实现未使用 `@Qualifier`
- 将工具类注册为单例 Bean 却无状态必要

## 关键 API / 注解

| 名称 | 说明 |
|------|------|
| `@Component` / `@Service` | 注册 Bean |
| `@Autowired` | 注入（构造器可省略） |
| `@Bean` | Java 配置类声明 Bean |
| `@Qualifier` | 指定实现 |

## 子项目规格

| 字段 | 值 |
|------|-----|
| **moduleId** | `sb-02-ioc-di` |
| **path** | `springboot/sb-02-ioc-di/` |
| **entry** | `com.lean.ioc.IocDiApplication` |

### Maven 依赖

`spring-boot-starter-web`、`spring-boot-starter-test`

### 包结构

| 类 | 说明 |
|----|------|
| `GreetingService` | 接口 |
| `EnglishGreetingService` | `@Service` 实现 |
| `GreetingController` | 注入 `GreetingService`，`GET /hi` |

### 运行与验证

```bash
cd springboot/sb-02-ioc-di
mvn spring-boot:run
curl http://localhost:8080/hi
```

**期望：** `Hello from IoC`

## 练习

1. 再实现 `ChineseGreetingService`，用 `@Profile("cn")` 切换。
2. 用 `@Configuration` + `@Bean` 注册 `Clock` 供测试。

## 参考资料

- [Using Spring Boot - Beans](https://docs.spring.io/spring-boot/docs/3.2.x/reference/html/using.html#using.auto-configuration)
