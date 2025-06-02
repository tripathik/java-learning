package com.iintelliguru.ds.slidingwindow.variableSize;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
@Slf4j
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int maxLength = 0;
        int start = 0;
        Set<Character> characterSet = new HashSet<>();
        for (int end = 0; end < str.length(); end++) {
            char currentChar = str.charAt(end);

            while (characterSet.contains(currentChar)) {
                characterSet.remove(str.charAt(start));
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
            characterSet.add(str.charAt(end));
        }
        log.info("Maximum Length: {}", maxLength);
    }
}
