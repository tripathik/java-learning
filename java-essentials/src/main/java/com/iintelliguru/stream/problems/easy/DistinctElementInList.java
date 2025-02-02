package com.iintelliguru.stream.problems.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistinctElementInList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> distinct = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("Distinct Element: "+ distinct);
    }
}
