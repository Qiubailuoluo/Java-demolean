# 本机开发环境（JavaLean）

本目录记录 **本地训练环境** 配置，便于 IDE 与 AI 协作时对齐路径与连接信息。  
内容为个人本机开发用途，**非生产环境**，请勿将生产密钥写入此处。

## 文档索引

| 文档 | 说明 |
|------|------|
| [jdk.md](jdk.md) | JDK 17 安装路径与 IDE 配置 |
| [maven.md](maven.md) | Maven 主路径、settings、本地仓库 |
| [mysql.md](mysql.md) | MySQL 连接默认值 |
| [redis.md](redis.md) | Redis 连接默认值 |
| [database/](../../database/README.md) | MySQL 库 `javalean` 建表与初始数据 |

## 使用说明

- 子项目 `pom.xml` **不要** 写死本机 JDK/Maven 绝对路径。
- 需要数据库/缓存的模块，在 `application.yml` 或文档中引用此处约定；库名按各 `moduleId` 文档单独创建。
- 若本机端口或密码变更，**只修改本目录对应文件**（最小影响）。

## 协作约束

项目级 AI 工作流见仓库根目录 [`.cursor/rules/javalean-workflow.mdc`](../../.cursor/rules/javalean-workflow.mdc)。
