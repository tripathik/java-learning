package com.iintelliguru.ds.slidingwindow.fixedSize;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubArraysCountWithTargetSum {
    static int arrayCount = 0;
    static int targetSum = 7;
    public static void main(String[] args) {
        int result = countNumberOfSubArraysWhoseElementSumEqualOrGreaterThan7();
        log.info("Total Count: {}", result);
    }

    private static int countNumberOfSubArraysWhoseElementSumEqualOrGreaterThan7() {
        int[] arr = {2, 1, 3, 4, 1, 2, 1, 5};
        int k = 3;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        incrementCount(sum);
        for (int i = 1; i < arr.length - k + 1; i++) {
            int previousElement = arr[i - 1];
            int nextElement = arr[i + k - 1];
            sum = sum - previousElement + nextElement;
            incrementCount(sum);

        }
        return arrayCount;
    }

    private static void incrementCount(int sum) {
        if (sum >= targetSum) {
            arrayCount++;
        }
    }
}