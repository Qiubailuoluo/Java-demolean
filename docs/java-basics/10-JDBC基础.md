# JDBC 基础

## 元信息

| 项 | 值 |
|----|-----|
| 板块 | java-basics |
| 难度 | 进阶 |
| 预估时长 | 4 小时 |
| 前置 | [04-异常机制](04-异常机制.md) |

## 学习目标

- [ ] 理解 JDBC 核心步骤：加载驱动、连接、Statement、ResultSet
- [ ] 使用 H2 内存库完成 CRUD
- [ ] 掌握 `PreparedStatement` 防 SQL 注入
- [ ] 了解连接池概念（本模块用 DriverManager 即可）

## 核心概念

### 定义

JDBC 是 Java 访问关系数据库的标准 API。生产环境通常使用连接池（HikariCP），本练习聚焦原生 API 与 SQL。

### 常见误区

- 字符串拼接 SQL
- 未关闭 `Connection`/`ResultSet`
- 在内存库与生产库方言差异上不做抽象

## 关键 API / 注解

| 名称 | 说明 |
|------|------|
| `DriverManager.getConnection` | 获取连接 |
| `PreparedStatement` | 预编译语句 |
| `ResultSet` | 结果集 |

## 对应代码

| 类 | 路径 |
|----|------|
| `JdbcDemo` | [`JdbcDemo.java`](../../java-basics/jb-10-jdbc/src/main/java/com/lean/jdbc/JdbcDemo.java) |
| `UserRepository` | [`UserRepository.java`](../../java-basics/jb-10-jdbc/src/main/java/com/lean/jdbc/UserRepository.java) |

本模块使用 **H2 内存库** 零配置演示；连接 MySQL `javalean` 库见 [database/docs](../../database/docs/README.md)，在 Spring / 后续扩展中练习。

## 子项目规格

| 字段 | 值 |
|------|-----|
| **moduleId** | `jb-10-jdbc` |
| **path** | `java-basics/jb-10-jdbc/` |
| **artifactId** | `jb-10-jdbc` |

### Maven 依赖（追加）

```xml
<dependency>
  <groupId>com.h2database</groupId>
  <artifactId>h2</artifactId>
  <version>2.2.224</version>
</dependency>
```

### 包结构

| 类 | 说明 |
|----|------|
| `com.lean.jdbc.UserRepository` | CRUD |
| `com.lean.jdbc.SchemaInit` | 建表 `user(id, name)` |
| `com.lean.jdbc.JdbcTest` | `@BeforeAll` 初始化 H2 |

### 配置

- JDBC URL：`jdbc:h2:mem:jblean;DB_CLOSE_DELAY=-1`

### 运行与验证

```bash
cd java-basics/jb-10-jdbc
mvn -q exec:java
mvn test
```

## 参考资料

- [JDBC](https://docs.oracle.com/javase/tutorial/jdbc/)
- [H2 Database](https://www.h2database.com/html/main.html)
