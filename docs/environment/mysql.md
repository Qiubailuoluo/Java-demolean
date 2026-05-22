# MySQL

本机训练用默认值（用户已确认）。

| 项 | 值 |
|----|-----|
| 主机 | `localhost` |
| 端口 | `3306` |
| 用户名 | `root` |
| 密码 | `root` |
| 默认练习库 | **`javalean`**（建表与种子数据见仓库 [`database/`](../../database/README.md)） |

## JDBC URL 模板

```
jdbc:mysql://localhost:3306/{database}?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8
```

## Spring Boot 示例（application.yml）

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/your_db?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver
```

## 说明

- 部分入门模块使用 **H2 内存库**（见 `jb-10-jdbc`、`sb-05-jpa` 文档），无需 MySQL。
- 需要 MySQL 的模块在实现阶段再建库；**不要**在仓库中提交生产库密码。
