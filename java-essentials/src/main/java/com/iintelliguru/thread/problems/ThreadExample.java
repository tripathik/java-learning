package com.iintelliguru.thread.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreadExample {
    private static final Set<String> userSet = new HashSet<>();

    public static void addValueToMap(){
        for(int i =0; i<5; i++){
            userSet.add(String.valueOf(i));
        }
    }

    public static void readValueFromMap(){
        List<String> userData = userSet.stream().collect(Collectors.toList());
    }
}
