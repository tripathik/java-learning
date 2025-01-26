package com.iintelliguru.stream.problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoinStringFromList {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

        String allDays = stringList.stream().collect(Collectors.joining(","));
        //OR

        String result = String.join(", ", stringList);
        System.out.println(allDays);
        System.out.println("Result: "+result);
    }
}
