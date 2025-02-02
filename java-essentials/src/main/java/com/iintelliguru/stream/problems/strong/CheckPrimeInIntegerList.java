package com.iintelliguru.stream.problems.strong;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
public class CheckPrimeInIntegerList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 6, 8, 10, 15, 7);
        boolean result  = numbers.stream().anyMatch(CheckPrimeInIntegerList::isPrime);
        log.info("Result: {}",result);

    }

    public static boolean isPrime(int num){
        if(num <= 1){
            return false;
        }
        return IntStream.rangeClosed(2, (int) Math.sqrt(num))
                .noneMatch(divisor -> num % divisor == 0);
    }
}
