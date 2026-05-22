# Nacos 替代方案速览

## 元信息

| 项 | 值 |
|----|-----|
| 板块 | springcloud |
| 难度 | 入门 |
| 预估时长 | 2 小时 |
| 前置 | [02-服务注册与发现-Eureka](02-服务注册与发现-Eureka.md)、[03-配置中心](03-配置中心.md) |
| **moduleId** | 无（对比文档，可选实现） |

## 学习目标

- [ ] 对比 Eureka + Config 与 Nacos 一站式能力
- [ ] 了解 Nacos 命名空间、分组、配置监听
- [ ] 知道 Alibaba Spring Cloud 与 Spring 官方套件关系
- [ ] 能根据团队技术栈选型

## Eureka vs Nacos（注册 + 配置）

| 维度 | Eureka + Config Server | Nacos |
|------|------------------------|-------|
| 组件数量 | 两个独立服务 | 一体化 |
| 配置推送 | 需 Bus/手动 refresh | 原生监听 |
| 控制台 | Eureka Dashboard | Nacos 控制台 |
| 云原生生态 | Spring 官方示例多 | 国内文档与案例多 |

## 可选 moduleId（阶段三）

| moduleId | 说明 |
|----------|------|
| `sc-nacos-discovery` | `spring-cloud-starter-alibaba-nacos-discovery` |
| `sc-nacos-config` | `spring-cloud-starter-alibaba-nacos-config` |

依赖版本需查 [spring-cloud-alibaba release notes](https://github.com/alibaba/spring-cloud-alibaba/wiki) 与 Boot 3.2 兼容矩阵。

### 配置示例（摘录）

```yaml
spring:
  cloud:
    nacos:
      discovery:
        server-addr: 127.0.0.1:8848
      config:
        server-addr: 127.0.0.1:8848
        file-extension: yaml
```

## 练习

1. 用 Docker 启动 Nacos `docker run -p 8848:8848 nacos/nacos-server` 浏览控制台。
2. 列表说明 JavaLean 选用 Eureka 教学、生产可换 Nacos 的理由。

## 参考资料

- [Nacos 文档](https://nacos.io/docs/latest/overview/)
- [Spring Cloud Alibaba](https://github.com/alibaba/spring-cloud-alibaba)
