# Lambda 与 Stream

## 元信息

| 项 | 值 |
|----|-----|
| 板块 | java-basics |
| 难度 | 进阶 |
| 预估时长 | 4 小时 |
| 前置 | [05-集合框架](05-集合框架.md)、[06-泛型](06-泛型.md) |

## 学习目标

- [ ] 会写 Lambda 与方法引用
- [ ] 掌握 Stream 的中间操作与终端操作
- [ ] 理解惰性求值与并行流注意事项
- [ ] 能用 Optional 减少 null 判断

## 核心概念

### 定义

Lambda 是函数式接口的实例语法糖。Stream 对集合做声明式数据处理，不修改原集合（除非终端 `forEach` 副作用）。

### 常见误区

- 在 parallel stream 中使用非线程安全共享状态
- 重复终端操作（Stream 只能消费一次）
- 过度嵌套 Lambda 降低可读性

## 关键 API / 注解

| 名称 | 说明 |
|------|------|
| `Stream` | 流 API |
| `map` / `filter` / `reduce` / `collect` | 常用操作 |
| `Optional` | 可选值 |
| `@FunctionalInterface` | 函数式接口 |

## 对应代码

| 类 | 路径 |
|----|------|
| `StreamDemo` | [`StreamDemo.java`](../../java-basics/jb-09-stream/src/main/java/com/lean/stream/StreamDemo.java) |
| `Employee` / `EmployeeStats` | 同包 `com.lean.stream` |

## 子项目规格

| 字段 | 值 |
|------|-----|
| **moduleId** | `jb-09-stream` |
| **path** | `java-basics/jb-09-stream/` |
| **artifactId** | `jb-09-stream` |

### 包结构

| 类 | 说明 |
|----|------|
| `com.lean.stream.Employee` | `record`：id, name, salary |
| `com.lean.stream.EmployeeStats` | Stream 聚合平均工资等 |
| `com.lean.stream.StreamTest` | JUnit 验证 |

### 运行与验证

```bash
cd java-basics/jb-09-stream
mvn -q exec:java
mvn test
```

## 参考资料

- [Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
- [Aggregate Operations](https://docs.oracle.com/javase/tutorial/collections/streams/)
