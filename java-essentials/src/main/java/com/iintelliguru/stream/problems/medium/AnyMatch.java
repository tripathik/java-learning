package com.iintelliguru.stream.problems.medium;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class AnyMatch {
    public static void main(String[] args) {
        checkIfListIntegerSatisfyTheCondition();
        checkIfWordInListContainsUpperCaseCharAt1stIndex();
    }

    public static void checkIfListIntegerSatisfyTheCondition(){
        List<Integer> mumList = Arrays.asList(3, 4, 7, 9, 5, 10);

        boolean result = mumList.stream()
                .anyMatch(
                        n-> (n*(n+1))/4 == 5
                );
        log.info("Result : {}", result);
    }

    public static void checkIfWordInListContainsUpperCaseCharAt1stIndex(){
        List<String> mumList = Arrays.asList("Radha", "krishna", "Tripti", "keshav");

        boolean result = mumList.stream()
                .anyMatch(
                        word -> Character.isUpperCase(word.charAt(1))
                );
        log.info("List Contains the word/s which first char is uppercase : {}", result);
    }
}
