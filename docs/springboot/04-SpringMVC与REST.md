# Spring MVC 与 REST

## 元信息

| 项 | 值 |
|----|-----|
| 板块 | springboot |
| 难度 | 入门 |
| 预估时长 | 3 小时 |
| 前置 | [03-配置文件与Profile](03-配置文件与Profile.md) |

## 学习目标

- [ ] 使用 `@RestController` 暴露 REST API
- [ ] 掌握 `@GetMapping`/`@PostMapping` 与路径变量、请求体
- [ ] 设计统一响应体 `ApiResponse<T>`
- [ ] 了解 `ResponseEntity` 与 HTTP 状态码

## 核心概念

### 定义

Spring MVC 通过 `DispatcherServlet` 分发请求。REST 风格用资源名词 + HTTP 动词表达操作。

### 常见误区

- GET 接口带副作用（修改数据）
- 不区分 404（资源不存在）与 400（参数错误）
- 在 Controller 写大量业务逻辑

## 关键 API / 注解

| 名称 | 说明 |
|------|------|
| `@RestController` | REST 控制器 |
| `@PathVariable` / `@RequestBody` | 参数绑定 |
| `ResponseEntity` | 自定义状态码与头 |

## 子项目规格

| 字段 | 值 |
|------|-----|
| **moduleId** | `sb-04-rest-api` |
| **path** | `springboot/sb-04-rest-api/` |
| **entry** | `com.lean.rest.RestApiApplication` |

### 包结构

| 类 | 说明 |
|----|------|
| `ApiResponse` | `record`：code, message, data |
| `Book` | `record`：id, title |
| `BookController` | CRUD 内存 Map |

### 运行与验证

```bash
cd springboot/sb-04-rest-api
mvn spring-boot:run
curl -X POST http://localhost:8080/api/books -H "Content-Type: application/json" -d "{\"title\":\"Spring\"}"
curl http://localhost:8080/api/books/1
```

## 练习

1. 增加分页查询 `GET /api/books?page=0&size=10`。
2. 使用 `ResponseEntity` 在删除不存在 id 时返回 404。

## 参考资料

- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
