# JavaLean 练习数据库

本目录为 **JavaLean 仓库统一 MySQL 库** 的建库、建表与初始数据脚本，供 `jb-10-jdbc`、`sb-05-jpa`、`sb-06-mybatis` 等模块练习使用。

## 库名

`javalean`

## 连接信息

见 [docs/environment/mysql.md](../docs/environment/mysql.md)（`root` / `root`，`localhost:3306`）。

## 初始化步骤

在 MySQL 客户端或命令行执行（按顺序）：

```bash
mysql -u root -proot < database/01-create-database.sql
mysql -u root -proot javalean < database/02-schema.sql
mysql -u root -proot javalean < database/03-seed-data.sql
```

Windows PowerShell 示例：

```powershell
mysql -u root -proot -e "source D:/JavaLean/database/01-create-database.sql"
mysql -u root -proot javalean -e "source D:/JavaLean/database/02-schema.sql"
mysql -u root -proot javalean -e "source D:/JavaLean/database/03-seed-data.sql"
```

## 表一览

| 表名 | 用途 |
|------|------|
| `t_user` | 用户 CRUD、条件查询 |
| `t_category` | 分类 |
| `t_product` | 商品、库存 |
| `t_order` / `t_order_item` | 订单与明细、关联查询 |
| `t_account` | 转账、事务练习 |
| `t_student` / `t_course` / `t_enrollment` | 多对多、选课 |

## 注意

- 仅用于本机训练，密码见环境文档。
- 重复执行 `02`/`03` 前可先 `DROP DATABASE javalean` 再重新 `01`（会清空数据）。
