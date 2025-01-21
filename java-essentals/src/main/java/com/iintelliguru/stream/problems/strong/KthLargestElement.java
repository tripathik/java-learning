package com.iintelliguru.stream.problems.strong;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class KthLargestElement {
    public static void main(String[] args) {
        /**
         * Given a list of integers and an integer k, find the Kth largest element using Java Streams.
         * The goal is to sort and pick the correct element.
         */

        List<Integer> numbers = Arrays.asList(3, 2, 1, 5, 6, 4);
        int k = 2;

        int result = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(k-1)
                .findFirst()
                .orElseThrow(()-> new RuntimeException("No elements are found"));
        System.out.println(result);
    }
}
