package com.iintelliguru.stream.problems.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertToUpperCase {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("raghav","Mohan","Sonia","tripti");
        List<String> upperCaseString = stringList.stream().map(String::toUpperCase).collect(Collectors.toList());
        for(String letter : upperCaseString){
            System.out.println(letter);
        }
    }
}
