# Java 基础模块（jb-*）

每个子目录为**独立 Maven 工程**，建议按 [docs/java-basics/](../docs/java-basics/) 文档顺序学习。

## 运行方式

```bash
cd java-basics/jb-03-oop   # 换成目标模块
mvn -q exec:java           # 运行 *Demo 主类
mvn test                   # 验收测试（非练习）
```

## 模块列表

| moduleId | 主类 | 说明 |
|----------|------|------|
| `jb-01-variables` | `VariableDemo` | 变量与类型 |
| `jb-02-control-flow` | `ControlFlowDemo` | 流程控制 |
| `jb-03-oop` | `OopDemo` | 面向对象 |
| `jb-04-exception` | `ExceptionDemo` | 异常 |
| `jb-05-collections` | `CollectionsDemo` | 集合 |
| `jb-06-generics` | `GenericsDemo` | 泛型 |
| `jb-07-io` | `IoDemo` | IO / NIO.2 |
| `jb-08-threading` | `ThreadingDemo` | 多线程 |
| `jb-09-stream` | `StreamDemo` | Lambda / Stream |
| `jb-10-jdbc` | `JdbcDemo` | JDBC（H2） |
| `jb-11-reflection` | `ReflectionDemo` | 反射与注解 |
| `jb-12-modern-java` | `ModernJavaDemo` | Java 17 新特性 |

`jb-01`、`jb-02` 另含 `*PracticeTest` 动手题（可选）。
