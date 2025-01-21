package com.iintelliguru.stream.problems.easy;

import java.util.Arrays;
import java.util.List;

public class CheckContains {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Stream", "Example", "");
        boolean result = words.stream().anyMatch(word-> words.contains("bk") || words.contains(""));
        System.out.println(result);
    }
}
