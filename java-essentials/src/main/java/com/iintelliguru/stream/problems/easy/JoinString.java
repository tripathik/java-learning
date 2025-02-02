package com.iintelliguru.stream.problems.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoinString {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("My", "name", "is", "Balkrishna");
        String joinedString = words.stream().collect(Collectors.joining(" "));
        System.out.println("Result: "+ joinedString);
    }
}
