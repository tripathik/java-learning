package com.iintelliguru.stream.problems.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupStringByLength {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "bat", "car", "stream");
        Map<Integer, List<String>> result =words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(result);

    }
}
