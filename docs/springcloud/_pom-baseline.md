# Spring Cloud 子项目 POM 基线

各 `sc-*` 模块在 Spring Boot 3.2.5 基线上增加 BOM：

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-dependencies</artifactId>
      <version>2023.0.1</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>
```

端口分配见 [_labs/local-dev-ports.md](_labs/local-dev-ports.md)。
