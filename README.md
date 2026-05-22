# JavaLean

Java 学习与练习仓库：按知识点拆分为**独立可运行的最小 Maven 单元**，覆盖 Java 基础、Spring Boot、Spring Cloud。

## 技术栈

| 项 | 版本 |
|----|------|
| Java | 17 |
| 构建 | Maven |
| Spring Boot | 3.2.5 |
| Spring Cloud | 2023.0.1 |

## 仓库结构

```
JavaLean/
├── .cursor/rules/     # 项目协作约束（AI 工作流）
├── docs/              # 知识点文档 + 本机环境说明
├── java-basics/       # jb-* 子项目（阶段二）
├── springboot/        # sb-* 子项目（阶段二）
└── springcloud/     # sc-* 子项目（阶段二）
```

## 协作约束

见 [.cursor/rules/javalean-workflow.mdc](.cursor/rules/javalean-workflow.mdc)：

- 不理解则追问，禁止臆测
- 分步推进，不一次性生成全部模块
- 最小影响原则
- **先骨架、确认后再补全代码**

## 本机环境

JDK、Maven、MySQL、Redis 等路径与连接信息见 [docs/environment/](docs/environment/README.md)（本机训练用）。

## 如何使用

1. 阅读 [docs/00-学习路线.md](docs/00-学习路线.md) 了解推荐学习顺序。
2. 在 [docs/README.md](docs/README.md) 中找到对应知识点文档。
3. 按文档中的 **子项目规格** 在对应板块目录下创建 `moduleId` 工程。
4. 本地验证：`mvn test` 或 `mvn spring-boot:run`（文档中会写明）。

## 子项目命名规范

| 板块 | 前缀 | 示例 |
|------|------|------|
| Java 基础 | `jb-` | `jb-05-collections` |
| Spring Boot | `sb-` | `sb-07-aop` |
| Spring Cloud | `sc-` | `sc-eureka-server` |

每个子文件夹为**独立 Maven 工程**（自带 `pom.xml`），不依赖父 POM 聚合。

## 阶段进度

| 阶段 | 状态 |
|------|------|
| 阶段一：docs 知识点文档 | 已完成 |
| 阶段二：代码子项目 | 进行中 |
| jb-01-variables | 已实现，可运行 |
| jb-02-control-flow | 已实现，可运行 |
| MySQL 练习库 `javalean` | 见 [database/](database/README.md)，需本地执行初始化脚本 |

## 文档入口

- [文档总索引](docs/README.md)
- [学习路线](docs/00-学习路线.md)
- [本机环境](docs/environment/README.md)
- [文档模板](docs/templates/知识点文档模板.md)

## Git 远程

`git@github.com:Qiubailuoluo/Java-demolean.git`
