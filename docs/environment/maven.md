# Maven

| 项 | 值 |
|----|-----|
| Maven 主路径 | `D:\My_download\java_MAVEN\apache-maven-3.6.3` |
| 版本 | **3.6.3** |
| 用户设置文件（Override） | `D:\My_download\java_MAVEN\apache-maven-3.6.3\conf\settings.xml` |
| 本地仓库（Override） | `D:\My_download\java_MAVEN\apache-maven-3.6.3\repo` |

## IntelliJ IDEA

- **Maven 主路径**：`D:\My_download\java_MAVEN\apache-maven-3.6.3`
- **用户设置文件**：勾选「重写」，指向上述 `conf\settings.xml`
- **本地仓库**：勾选「重写」，指向上述 `repo`

## 命令行（可选）

```powershell
$env:M2_HOME = "D:\My_download\java_MAVEN\apache-maven-3.6.3"
$env:Path = "$env:M2_HOME\bin;" + $env:Path
mvn -version
```

## 版本说明

- Spring Boot **3.2.x** 官方建议 Maven **3.6.3+**；当前 3.6.3 为可用下限。
- 若后续构建或插件异常，可考虑升级到 Maven 3.8+（需自行在本机安装并更新 IDE 配置）。

## 与 JavaLean 关系

- 各 `jb-*` / `sb-*` / `sc-*` 为独立 Maven 工程，在模块目录执行 `mvn test` 或 `mvn spring-boot:run`。
- 不在项目 `pom.xml` 中配置 `localRepository` 绝对路径，沿用本机 `settings.xml`。
