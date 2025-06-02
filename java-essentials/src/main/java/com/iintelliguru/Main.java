package com.iintelliguru;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Simple project for Java Core Concepts");

//        int k =0;
//        int val = 4;
//        int[] num = {1,4,4,6,9,3};
//        for(int i =0; i<num.length; i++){
//            if(num[i] != val){
//                num[k] = num[i];
//                k++;
//            }
//        }


//        String str = "abcabcbb";
//        int result = longestSubstringWithoutRepeatingCharacters(str);

        int[] arr = {100, 200, 300, 400};
        int k = 2;
        int result = maximumSumOfSubArrayOfSizeK(arr, k);
    }

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[]{};
    }

    // Sliding Window/Two pointers
    static int longestSubstringWithoutRepeatingCharacters(String strs) {
        return 0;
    }

    static int maximumSumOfSubArrayOfSizeK(int[] arr, int k) {

        int maxSum = 0;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int sum=0;
            for (int j = i; j < i + k; j++){
                sum += arr[j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

}