package com.iintelliguru.stream.problems.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterStringByLength {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "stream", "example", "java");

        List<String> filteredStringList = words.stream().filter(word->word.length()<6).collect(Collectors.toList());
        System.out.println("Result: "+filteredStringList);
    }
}
