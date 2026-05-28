package com.lean.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

/**
 * 用户仓储：演示 PreparedStatement 防 SQL 注入、try-with-resources 关闭连接。
 */
public class UserRepository {

    private final String url;
    private final String user;
    private final String password;

    public UserRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public static UserRepository inMemory() {
        return new UserRepository(SchemaInit.JDBC_URL, SchemaInit.USER, SchemaInit.PASSWORD);
    }

    /** 插入并返回自增 id */
    public long insert(String name) throws SQLException {
        String sql = "INSERT INTO demo_user(name) VALUES (?)";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, name);
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getLong(1);
                }
            }
        }
        throw new SQLException("未获取到自增主键");
    }

    public Optional<String> findNameById(long id) throws SQLException {
        String sql = "SELECT name FROM demo_user WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(rs.getString("name"));
                }
                return Optional.empty();
            }
        }
    }

    private Connection connect() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        SchemaInit.init(conn);
        return conn;
    }
}
