# AOP

## 元信息

| 项 | 值 |
|----|-----|
| 板块 | springboot |
| 难度 | 进阶 |
| 预估时长 | 3 小时 |
| 前置 | [04-SpringMVC与REST](04-SpringMVC与REST.md) |

## 学习目标

- [ ] 理解切面、切点、通知类型
- [ ] 使用 `@Aspect`、`@Around` 记录方法耗时
- [ ] 了解 AOP 基于代理（JDK/CGLIB）对 `this` 调用的影响
- [ ] 将横切关注点从业务代码剥离

## 核心概念

### 定义

面向切面编程将日志、权限、事务等横切逻辑模块化。Spring AOP 默认仅拦截 Spring 管理的 Bean 的 public 方法。

### 常见误区

- 同类内部自调用不经过代理，切面不生效
- 切点表达式过宽影响性能
- 在 `@Around` 中忘记 `proceed()` 导致业务不执行

## 关键 API / 注解

| 名称 | 说明 |
|------|------|
| `@Aspect` | 切面类 |
| `@Around` / `@Before` | 通知 |
| `@Pointcut` | 切点复用 |

## 子项目规格

| 字段 | 值 |
|------|-----|
| **moduleId** | `sb-07-aop` |
| **path** | `springboot/sb-07-aop/` |
| **entry** | `com.lean.aop.AopDemoApplication` |

### Maven 依赖

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

### 包结构

| 类 | 说明 |
|----|------|
| `LoggingAspect` | `@Around` 打印耗时 |
| `HelloController` | `GET /hello` |
| `HelloService` | 被切面拦截 |

### 运行与验证

```bash
cd springboot/sb-07-aop
mvn spring-boot:run
curl http://localhost:8080/hello
```

**期望：** 响应 `hello` 且控制台有 `took xxx ms` 日志。

## 练习

1. 仅对 `com.lean.aop.service..*` 包做切点。
2. 实现注解 `@Timed` + 切面按注解拦截。

## 参考资料

- [Aspect-Oriented Programming](https://docs.spring.io/spring-framework/reference/core/aop.html)
