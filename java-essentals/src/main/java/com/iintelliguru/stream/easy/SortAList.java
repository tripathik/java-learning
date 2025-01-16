package com.iintelliguru.stream.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortAList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 3);
        numbers = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(numbers);
    }
}
