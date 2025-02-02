package com.iintelliguru.stream.problems.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Map<Boolean, List<Integer>> result = numbers.stream().collect(Collectors.partitioningBy(key -> key % 2 != 0));
        System.out.println(result);
    }
}
