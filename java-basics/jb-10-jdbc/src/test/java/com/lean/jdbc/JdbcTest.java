package com.lean.jdbc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JdbcTest {

    private static UserRepository repo;

    @BeforeAll
    static void setUp() throws Exception {
        try (Connection conn = DriverManager.getConnection(
                SchemaInit.JDBC_URL, SchemaInit.USER, SchemaInit.PASSWORD)) {
            SchemaInit.init(conn);
        }
        repo = UserRepository.inMemory();
    }

    @Test
    void insertAndFind() throws Exception {
        long id = repo.insert("alice");
        assertEquals("alice", repo.findNameById(id).orElseThrow());
        assertTrue(repo.findNameById(9999L).isEmpty());
    }
}
