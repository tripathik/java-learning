package com.iintelliguru.ds.slidingwindow.fixedSize;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FindMaximumOfAllSubArrays {
    public static void main(String[] args) {
        int[] result = maximumOfAllSubArrays();
        log.info("Result: {}", result);
    }

    private static int[] maximumOfAllSubArrays() {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < arr.length - k + 1; i++) {
            int maxElement = arr[i];
            for (int j = i; j < i + k; j++) {
                if (arr[j] > maxElement) {
                    maxElement = arr[j];
                }
            }
            numberList.add(maxElement);
        }
        return numberList.stream().mapToInt(Integer::intValue).toArray();
    }
}
