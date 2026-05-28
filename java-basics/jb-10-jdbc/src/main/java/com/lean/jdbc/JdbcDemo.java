package com.lean.jdbc;

/**
 * JDBC 演示入口。
 * <p>对应文档：docs/java-basics/10-JDBC基础.md</p>
 * <p>连接 MySQL 练习库见 jb 后续与 Spring 模块；本模块用 H2 内存库零配置运行。</p>
 */
public class JdbcDemo {

    public static void main(String[] args) throws Exception {
        UserRepository repo = UserRepository.inMemory();
        long id = repo.insert("JavaLean");
        System.out.println("插入 id=" + id);
        System.out.println("查询 name=" + repo.findNameById(id).orElse("未找到"));
    }
}
