package com.iintelliguru.stream.problems.medium;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
public class FindCommonIntegers {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(5, 1, 9, 3, 7, 2);
        List<Integer> list2 = Arrays.asList(8, 3, 6, 1, 9, 4);
        List<Integer> commonIntegers = getCommonIntegers(list1, list2);
        log.info("Common Integers: {}", commonIntegers);
    }

    public static List<Integer> getCommonIntegers(List<Integer> list1, List<Integer> list2){
        return list1.stream()
                .sorted()
                .filter(list2::contains)
                .distinct()
                .collect(Collectors.toList());
    }
}
