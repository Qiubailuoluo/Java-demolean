# JDK

| 项 | 值 |
|----|-----|
| 名称（IDE 别名） | `ms-17` |
| 发行版 | Microsoft OpenJDK |
| 版本 | **17.0.15** |
| 安装路径 | `D:/My_download/JDK17` |

## IntelliJ IDEA

- **导入程序的 JDK**：选择 `ms-17` → `Microsoft OpenJDK 17.0.15`，路径 `D:/My_download/JDK17`
- 项目语言级别：**17**

## 命令行（可选）

```powershell
$env:JAVA_HOME = "D:\My_download\JDK17"
$env:Path = "$env:JAVA_HOME\bin;" + $env:Path
java -version
```

## 与 JavaLean 关系

- 所有子项目 `pom.xml` 使用 `<maven.compiler.source>17</maven.compiler.source>`（或 Spring Boot parent 的 `java.version`）。
- Spring Boot 3.x **要求** Java 17+，与本机 JDK 一致。
