# IO 与 NIO 入门

## 元信息

| 项 | 值 |
|----|-----|
| 板块 | java-basics |
| 难度 | 进阶 |
| 预估时长 | 4 小时 |
| 前置 | [04-异常机制](04-异常机制.md) |

## 学习目标

- [ ] 掌握字节流/字符流与缓冲流
- [ ] 使用 try-with-resources 管理流
- [ ] 了解 `java.nio.file.Files` 读写文本
- [ ] 能完成简单文件复制与目录遍历

## 核心概念

### 定义

传统 IO 以流为中心；NIO.2（`java.nio.file`）提供 Path/Files 等现代文件 API，适合学习与生产中的文件操作。

### 常见误区

- 未指定 `Charset` 导致中文乱码
- 未使用缓冲流导致性能差
- 忘记关闭流（应使用 try-with-resources）

## 关键 API / 注解

| 名称 | 说明 |
|------|------|
| `InputStream` / `OutputStream` | 字节流 |
| `Reader` / `Writer` | 字符流 |
| `Files.readString` / `Files.writeString` | NIO.2 便捷方法 |
| `Path` / `Paths` | 路径 |

## 对应代码

| 类 | 路径 |
|----|------|
| `IoDemo` | [`IoDemo.java`](../../java-basics/jb-07-io/src/main/java/com/lean/io/IoDemo.java) |
| `FileCopyUtil` | [`FileCopyUtil.java`](../../java-basics/jb-07-io/src/main/java/com/lean/io/FileCopyUtil.java) |

## 子项目规格

| 字段 | 值 |
|------|-----|
| **moduleId** | `jb-07-io` |
| **path** | `java-basics/jb-07-io/` |
| **artifactId** | `jb-07-io` |

### 包结构

| 类 | 说明 |
|----|------|
| `com.lean.io.FileCopyUtil` | 复制文件到 `target/` |
| `com.lean.io.IoDemo` | `main` 写读文本 |
| `com.lean.io.FileCopyUtilTest` | 临时目录断言 |

### 运行与验证

```bash
cd java-basics/jb-07-io
mvn test
```

**验证步骤：** `mvn -q exec:java` 在 `target/io-demo` 生成文件；`mvn test` 在临时目录断言复制。

## 参考资料

- [Basic I/O](https://docs.oracle.com/javase/tutorial/essential/io/)
- [File I/O (Featuring NIO.2)](https://docs.oracle.com/javase/tutorial/essential/io/file.html)
