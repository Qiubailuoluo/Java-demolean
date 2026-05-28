package com.lean.io;

import java.nio.file.Path;

/**
 * IO 演示：NIO.2 写读文本、复制文件。
 * <p>对应文档：docs/java-basics/07-IO与NIO入门.md</p>
 */
public class IoDemo {

    public static void main(String[] args) throws Exception {
        Path dir = Path.of("target", "io-demo");
        Path source = dir.resolve("hello.txt");
        Path copy = dir.resolve("hello-copy.txt");

        FileCopyUtil.writeText(source, "你好，JavaLean IO\n");
        System.out.println("写入: " + source.toAbsolutePath());
        System.out.println("内容: " + FileCopyUtil.readText(source));

        FileCopyUtil.copy(source, copy);
        System.out.println("复制到: " + copy.toAbsolutePath());
        System.out.println("副本内容: " + FileCopyUtil.readText(copy));
    }
}
