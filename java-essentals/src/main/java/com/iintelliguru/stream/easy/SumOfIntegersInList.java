package com.iintelliguru.stream.easy;

import java.util.Arrays;
import java.util.List;

public class SumOfIntegersInList {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 32, 7, 37, 89);

        //Using normal for loop
        int res = 0;
        for(int i =0; i<integerList.size(); i++){
            res = res + integerList.get(i);
        }
        System.out.println("Using for loop, sum: "+res);
        //Using for each loop
        int sum = 0;
        for (int n : integerList) {
            sum+=n;
        }
        System.out.println("Using for each loop, sum: "+sum);

        int sum1 = integerList.stream().reduce(0, Integer::sum);
        int sum2 = integerList.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Using Java Stream with two approach, First Sum: " + sum1 + ", 2nd Sum: " + sum2);
    }
}
