package com.lean.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * H2 内存库建表。生产环境用 Flyway/Liquibase，本模块仅演示原生 JDBC。
 */
public final class SchemaInit {

    public static final String JDBC_URL = "jdbc:h2:mem:jblean;DB_CLOSE_DELAY=-1";
    public static final String USER = "sa";
    public static final String PASSWORD = "";

    private SchemaInit() {
    }

    public static void init(Connection conn) throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.execute("""
                    CREATE TABLE IF NOT EXISTS demo_user (
                        id   BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100) NOT NULL
                    )
                    """);
        }
    }
}
