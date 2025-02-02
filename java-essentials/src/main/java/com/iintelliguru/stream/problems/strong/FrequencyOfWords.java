package com.iintelliguru.stream.problems.strong;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfWords {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple");
        Map<String, Long> resultMap = words.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting())
        );
        System.out.println(resultMap);
    }
}
