package com.iintelliguru.ds.slidingwindow.fixedSize;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxAvgOfSubArrayOfSizeK {
    static int[] arr = {100, 200, 300, 400};
    static int k = 2;

    public static void main(String[] args) {
        float result = maxAvgOfAnySubArrayOfSizeK();
        log.info("Result: {}", result);
    }

    public static float maxAvgOfAnySubArrayOfSizeK() {
        int[] arr = {2, 3, 7, 8, 9, 5, 10, 7, 6, 0, -3, 4, -11};
        int k = 4;
        int n = arr.length;

        float maxAvg;
        float avg;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        avg = (float) sum /k;
        maxAvg = avg;

        for (int i = 1; i < n - k + 1; i++) {
            int previousElement = arr[i - 1];
            int nextElement = arr[i + k - 1];
            sum = sum - previousElement + nextElement;
            avg = (float) sum/k;
            maxAvg = Math.max(maxAvg, avg);
        }
        return maxAvg;
    }
}
