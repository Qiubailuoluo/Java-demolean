# Redis

本机训练用默认值。

| 项 | 值 |
|----|-----|
| 主机 | `localhost` |
| 端口 | `6379` |
| 密码 | **无**（空） |
| 数据库索引 | `0`（默认，可按模块调整） |

## Spring Boot 示例（application.yml）

```yaml
spring:
  data:
    redis:
      host: localhost
      port: 6379
      # 无密码时不配置 password
```

## 连接 URL（部分客户端）

```
redis://localhost:6379/0
```

## 说明

- 当前 JavaLean 文档阶段以知识点为主；引入 Redis 的 Spring Boot 模块在后续 `sb-*` 扩展时再配置。
- 若本机 Redis 设置了密码，请只更新本文件并向协作者说明，勿臆测。
