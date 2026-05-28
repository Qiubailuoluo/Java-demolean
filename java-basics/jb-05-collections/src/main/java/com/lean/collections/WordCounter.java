package com.lean.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 词频统计：演示 {@link Map#merge} 与不可变返回。
 */
public final class WordCounter {

    private WordCounter() {
    }

    /**
     * @param words 单词列表（区分大小写）
     * @return 单词 → 出现次数（不可修改视图）
     */
    public static Map<String, Integer> count(List<String> words) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            // merge：无键则放入 1，有键则 old+1
            freq.merge(word, 1, Integer::sum);
        }
        return Collections.unmodifiableMap(freq);
    }
}
