# javalean 数据库文档

本目录记录 **`javalean`** 库的结构说明与常用查询，便于 Navicat / 命令行查阅。  
建表脚本仍以上级目录 [`../02-schema.sql`](../02-schema.sql) 为准。

## 文档索引

| 文档 | 说明 |
|------|------|
| [schema-overview.md](schema-overview.md) | 表清单、字段摘要、表关系、当前数据量 |
| [sample-queries.sql](sample-queries.sql) | 可按块复制执行的练习 SQL |

## 快速连接

| 项 | 值 |
|----|-----|
| 库名 | `javalean` |
| 主机 | `localhost:3306` |
| 用户 / 密码 | `root` / `root` |

详见 [docs/environment/mysql.md](../../docs/environment/mysql.md)。

## 目录结构

```
database/
├── 01-create-database.sql
├── 02-schema.sql
├── 03-seed-data.sql
├── README.md
└── docs/          ← 本目录（查阅用，非执行脚本）
    ├── README.md
    ├── schema-overview.md
    └── sample-queries.sql
```

## 状态

本机已初始化完成（9 张表 + 种子数据）。若需重建，见 [../README.md](../README.md)。
