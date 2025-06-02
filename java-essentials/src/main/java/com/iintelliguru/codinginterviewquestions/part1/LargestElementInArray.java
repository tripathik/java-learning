package com.iintelliguru.codinginterviewquestions.part1;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class LargestElementInArray {
    public static void main(String[] args) {
        int[] intArray = {-10, -1, -214, 0, -47, -87};

        log.info("By sorting the array: {}", bySortingTheArray(intArray));
        log.info("By comparing array element in a loop: {}", byComparingElement(intArray));
        log.info("By Using recursive approach {}", byUsingRecursiveApproach(intArray, 6));
    }



    private static int bySortingTheArray(int[] array) {
        Arrays.sort(array);
        return array[array.length - 1];
    }

    private static int byComparingElement(int[] intArray) {
        int maxElement = Integer.MIN_VALUE;
        for (int j : intArray) {
            if (j > maxElement) {
                maxElement = j;
            }
        }
        return maxElement;
    }

    private static int byUsingRecursiveApproach(int[] intArray, int length) {

        if(length == 1){
            return intArray[0];
        }
        int maxOfRest = byUsingRecursiveApproach(intArray, length-1);
        return Math.max(intArray[length-1], maxOfRest);
    }
}
