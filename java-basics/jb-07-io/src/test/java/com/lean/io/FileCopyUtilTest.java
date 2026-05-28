package com.lean.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileCopyUtilTest {

    @Test
    void copyPreservesContent(@TempDir Path temp) throws Exception {
        Path src = temp.resolve("a.txt");
        Path dst = temp.resolve("b.txt");
        FileCopyUtil.writeText(src, "copy-me");
        FileCopyUtil.copy(src, dst);
        assertEquals("copy-me", FileCopyUtil.readText(dst));
    }
}
