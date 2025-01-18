package com.iintelliguru.stream.problems.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindEvenNumber {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(23, 52, 18, 27,98,10,9);
        List<Integer> evenNumList = integerList.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println("Even Numbers are:");
        for(int num: evenNumList){
            System.out.println(num);
        }
    }
}
