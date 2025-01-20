package com.iintelliguru.stream.problems.medium;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindFirstMatchingElement {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Apple", "Banana", "Berry", "Avocado");

        String result = String.valueOf(names.stream().filter(key-> key.startsWith("B")).findFirst());
        System.out.println(result);
    }
}
