package com.iintelliguru.stream.problems.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestStringInList {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "stream", "example");
        String result = words.stream()
                .max(Comparator.comparing(String::length)).toString();
        System.out.println(result);
    }
}
