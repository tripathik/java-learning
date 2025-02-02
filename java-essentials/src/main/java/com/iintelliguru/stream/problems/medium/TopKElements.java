package com.iintelliguru.stream.problems.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TopKElements
{
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 7);
        List<Integer> topNums = numbers
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(3).collect(Collectors.toList());
        System.out.println(topNums);
    }
}
