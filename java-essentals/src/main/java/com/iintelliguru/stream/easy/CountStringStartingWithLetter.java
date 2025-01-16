package com.iintelliguru.stream.easy;

import java.util.Arrays;
import java.util.List;

public class CountStringStartingWithLetter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Apple", "Banana", "Avocado", "Berry");
        int count = (int) names.stream().filter(word-> word.startsWith("A")).count();
        System.out.println("Total number of words starts with A, are: "+count);
    }
}
