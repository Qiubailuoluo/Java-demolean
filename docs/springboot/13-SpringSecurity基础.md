# Spring Security 基础

## 元信息

| 项 | 值 |
|----|-----|
| 板块 | springboot |
| 难度 | 进阶 |
| 预估时长 | 4 小时 |
| 前置 | [04-SpringMVC与REST](04-SpringMVC与REST.md) |

## 学习目标

- [ ] 引入 Security 并理解默认拦截行为
- [ ] 配置内存用户与 BCrypt 密码
- [ ] 区分公开接口与需认证接口
- [ ] 使用 Basic 或表单登录（本模块用 HTTP Basic 简化）

## 核心概念

### 定义

Spring Security 基于过滤器链实现认证与授权。Boot 3 使用 `SecurityFilterChain` Bean 配置（非 WebSecurityConfigurerAdapter）。

### 常见误区

- 密码明文存储
- CSRF 在 REST 场景处理不当
- 自定义配置后仍被默认用户覆盖

## 关键 API / 注解

| 名称 | 说明 |
|------|------|
| `SecurityFilterChain` | 安全配置 |
| `UserDetailsService` | 加载用户 |
| `PasswordEncoder` | 密码编码 |
| `@PreAuthorize` | 方法级授权（需 `@EnableMethodSecurity`） |

## 子项目规格

| 字段 | 值 |
|------|-----|
| **moduleId** | `sb-13-security-basic` |
| **path** | `springboot/sb-13-security-basic/` |
| **entry** | `com.lean.security.SecurityBasicApplication` |

### Maven 依赖

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

### 包结构

| 类 | 说明 |
|----|------|
| `SecurityConfig` | `SecurityFilterChain`：/public 放行，其余认证 |
| `PublicController` | `GET /public/hello` |
| `SecureController` | `GET /secure/me` |

### 测试用户（内存）

- 用户名：`user` / 密码：`password`（BCrypt 编码后配置）

### 运行与验证

```bash
cd springboot/sb-13-security-basic
mvn spring-boot:run
curl http://localhost:8080/public/hello
curl -u user:password http://localhost:8080/secure/me
```

## 练习

1. 启用 `@PreAuthorize("hasRole('ADMIN')")` 于管理接口。
2. 写笔记：JWT 无状态认证与 Session 区别。

## 参考资料

- [Spring Security](https://docs.spring.io/spring-security/reference/index.html)
