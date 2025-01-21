package com.iintelliguru.stream.problems.strong;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostFrequentElement {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3);
        int result = numbers.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey)
                .orElse(0);
        System.out.println("The most frequent Number is: " + result);
    }
}
