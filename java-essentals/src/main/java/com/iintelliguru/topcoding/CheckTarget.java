package com.iintelliguru.topcoding;

import java.util.Arrays;

public class CheckTarget {
    public static void main(String[] args) {
        int[] array = {10, 12, 9, 22, 30};
        int target = 21;
        CheckTarget checkTarget = new CheckTarget();
        boolean result = checkTarget.checkTarget(array, target);
    }

    /**
     * Given an integer array and an integer "target"
     * Find if any pair or element in array sums to the target
     * int[] arr = {10, 12, 9, 22,30}, int target = 21
     * HINT: We will be using Two Pointer Approach
     */

    public boolean checkTarget(int[] arr, int target) {
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                return true;
            }
            else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
