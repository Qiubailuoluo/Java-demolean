package com.lean.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 基于 NIO.2 {@link Files} 的文件复制（字节级，适合任意文件类型）。
 */
public final class FileCopyUtil {

    private FileCopyUtil() {
    }

    /**
     * 将源文件复制到目标路径（覆盖已存在目标）。
     */
    public static void copy(Path source, Path target) throws IOException {
        Files.createDirectories(target.getParent());
        Files.copy(source, target, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
    }

    /** 读写文本便捷方法，显式指定 UTF-8 避免乱码 */
    public static void writeText(Path path, String content) throws IOException {
        Files.writeString(path, content, StandardCharsets.UTF_8);
    }

    public static String readText(Path path) throws IOException {
        return Files.readString(path, StandardCharsets.UTF_8);
    }
}
