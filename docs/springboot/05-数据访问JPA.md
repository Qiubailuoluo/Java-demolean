# 数据访问 JPA

## 元信息

| 项 | 值 |
|----|-----|
| 板块 | springboot |
| 难度 | 进阶 |
| 预估时长 | 4 小时 |
| 前置 | [04-SpringMVC与REST](04-SpringMVC与REST.md) |

## 学习目标

- [ ] 配置 Spring Data JPA 与 H2
- [ ] 定义实体 `@Entity` 与 `JpaRepository`
- [ ] 完成基本 CRUD 与派生查询方法
- [ ] 了解 `ddl-auto` 与生产环境迁移工具（Flyway）概念

## 核心概念

### 定义

JPA 是 Java 持久化规范，Hibernate 为常见实现。Spring Data JPA 通过接口代理减少样板 SQL。

### 常见误区

- 生产使用 `ddl-auto=create-drop`
- 懒加载在 Controller 层触发 `LazyInitializationException`
- 实体双向关联导致 JSON 循环引用

## 关键 API / 注解

| 名称 | 说明 |
|------|------|
| `@Entity` / `@Id` | 实体映射 |
| `JpaRepository` | 仓储接口 |
| `@Transactional` | 事务边界 |

## 子项目规格

| 字段 | 值 |
|------|-----|
| **moduleId** | `sb-05-jpa` |
| **path** | `springboot/sb-05-jpa/` |
| **entry** | `com.lean.jpa.JpaApplication` |

### Maven 依赖

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
  <groupId>com.h2database</groupId>
  <artifactId>h2</artifactId>
  <scope>runtime</scope>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

### application.yml

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:jpa_demo
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
  h2:
    console:
      enabled: true
```

### 包结构

| 类 | 说明 |
|----|------|
| `User` | 实体 |
| `UserRepository` | `JpaRepository<User, Long>` |
| `UserController` | REST CRUD |

### 运行与验证

```bash
cd springboot/sb-05-jpa
mvn spring-boot:run
curl -X POST http://localhost:8080/users -H "Content-Type: application/json" -d "{\"name\":\"alice\"}"
curl http://localhost:8080/users
```

## 练习

1. 添加 `findByNameContaining` 派生查询。
2. 访问 `/h2-console` 查看表（仅 dev）。

## 参考资料

- [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
