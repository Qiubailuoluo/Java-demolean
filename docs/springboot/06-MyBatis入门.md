# MyBatis 入门

## 元信息

| 项 | 值 |
|----|-----|
| 板块 | springboot |
| 难度 | 进阶 |
| 预估时长 | 4 小时 |
| 前置 | [04-SpringMVC与REST](04-SpringMVC与REST.md) |

## 学习目标

- [ ] 集成 `mybatis-spring-boot-starter`
- [ ] 编写 Mapper 接口与 XML SQL
- [ ] 对比 JPA 与 MyBatis 适用场景
- [ ] 完成简单用户查询 API

## 核心概念

### 定义

MyBatis 是半自动 ORM，SQL 由开发者编写，灵活控制复杂查询与存储过程。适合遗留库或复杂 SQL 场景。

### 常见误区

- XML namespace 与接口全限定名不一致
- `#{}` 与 `${}` 混用导致 SQL 注入（`${}` 仅用于动态表名列名）
- 不开启驼峰映射导致字段对不上

## 关键 API / 注解

| 名称 | 说明 |
|------|------|
| `@Mapper` | 扫描 Mapper |
| `@Select` / XML `<select>` | 查询映射 |
| `mybatis.mapper-locations` | XML 路径 |

## 子项目规格

| 字段 | 值 |
|------|-----|
| **moduleId** | `sb-06-mybatis` |
| **path** | `springboot/sb-06-mybatis/` |
| **entry** | `com.lean.mybatis.MybatisApplication` |

### Maven 依赖

```xml
<dependency>
  <groupId>org.mybatis.spring.boot</groupId>
  <artifactId>mybatis-spring-boot-starter</artifactId>
  <version>3.0.3</version>
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

### 资源

- `src/main/resources/mapper/UserMapper.xml`
- `schema.sql` 初始化 `user` 表

### 包结构

| 类 | 说明 |
|----|------|
| `UserMapper` | `@Mapper` |
| `UserController` | `GET /users/{id}` |

### application.yml

```yaml
mybatis:
  mapper-locations: classpath:mapper/*.xml
  configuration:
    map-underscore-to-camel-case: true
spring:
  sql:
    init:
      mode: always
```

### 运行与验证

```bash
cd springboot/sb-06-mybatis
mvn spring-boot:run
curl http://localhost:8080/users/1
```

## 练习

1. 将插入用户改为 XML `<insert>`。
2. 写笔记：本仓库何时选 JPA 何时选 MyBatis。

## 参考资料

- [MyBatis Spring Boot](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)
