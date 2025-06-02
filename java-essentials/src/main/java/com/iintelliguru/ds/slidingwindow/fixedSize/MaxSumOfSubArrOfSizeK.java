package com.iintelliguru.ds.slidingwindow.fixedSize;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxSumOfSubArrOfSizeK {

    static int[] arr = {100, 200, 300, 400};
    static int k = 2;

    public static void main(String[] args) {
        int result = optimalApproach();
        log.info("Result: {}", result);
    }

    static int bruteForceApproach() {
        int maxSum = 0;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
        // Time Complexity : (N-K) * K = Nk-k^2
    }

    static int optimalApproach() {
        int sum = 0;
        int maxSum;

        for (int i = 0; i < k; i++) {
            sum = sum + arr[i];
        }
        maxSum = sum;

        for (int i = 1; i < arr.length - k + 1; i++) {
            int previousElement = arr[i - 1];
            int nextElement = arr[i + k - 1];
            sum = sum - previousElement + nextElement;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
