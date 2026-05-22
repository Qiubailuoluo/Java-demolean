# Spring Boot 子项目 POM 基线

各 `sb-*` 模块独立 `pom.xml`，共用以下片段（文档中引用，阶段二复制）。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.2.5</version>
    <relativePath/>
  </parent>

  <groupId>com.lean</groupId>
  <artifactId><!-- 替换为 moduleId --></artifactId>
  <version>1.0-SNAPSHOT</version>
  <name><!-- 模块名 --></name>

  <properties>
    <java.version>17</java.version>
  </properties>

  <dependencies>
    <!-- 各模块追加 -->
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </build>
</project>
```

默认端口：`8080`（若未在 `application.yml` 中覆盖）。
