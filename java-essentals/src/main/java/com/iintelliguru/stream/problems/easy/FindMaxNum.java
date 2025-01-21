package com.iintelliguru.stream.problems.easy;

import java.util.Arrays;
import java.util.List;

public class FindMaxNum {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 9, 1, 7, 5);
        int num = numbers.stream().max(Integer::compareTo).get();
        System.out.println(" Maximum Number is: "+num);
    }
}
