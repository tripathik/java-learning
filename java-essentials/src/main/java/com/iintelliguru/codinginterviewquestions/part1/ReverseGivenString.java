package com.iintelliguru.codinginterviewquestions.part1;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class ReverseGivenString {
    //Write a Java program to reverse a given string.
    public static void main(String[] args) {
        String str = "abcd";

        String reversedString1 = normalApproach(str);
        log.info("Result using normal approach: {}", reversedString1);

        String reversedString2 = usingStringBuilderReverse(str);
        log.info("Result using StringBuilder reverse() method: {}", reversedString2);

        String reversedString3 = usingCharArray(str);
        log.info("Result using character array: {}", reversedString3);

        String reversedString4 = usingStack(str);
        log.info("Result using Stack: {}", reversedString4);

        String reversedString5 = usingCollectionsDotReverse(str);
        log.info("Result using Collections.reverse() : {}", reversedString5);

        String reversedString6 = byIteratingEachCharAndAddingItToFrontOfNewString("anhsirklaB");
        log.info("Result using Collections.reverse() : {}", reversedString6);
    }

    //1.
    private static String normalApproach(String str) {
        String reversedString = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString += str.charAt(i);
        }
        return reversedString;
    }

    //2.
    private static String usingStringBuilderReverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    //3.
    private static String usingCharArray(String str) {
        String reversedString = "";
        char[] charArray = str.toCharArray();

        for (int i = charArray.length - 1; i >= 0; i--) {
            reversedString += charArray[i];
        }
        return reversedString;
    }

    //4.
    private static String usingStack(String str){
        Stack<Character> stringStack = new Stack<>();
        String reversedString = "";

        for(char c: str.toCharArray()){
            stringStack.push(c);
        }

        while (!stringStack.isEmpty()){
            reversedString += stringStack.pop();
        }
        return reversedString;
    }

    //5.
    private static String usingCollectionsDotReverse(String str) {
        List<Character> charList = new ArrayList<>();
        for (char c : str.toCharArray()){
            charList.add(c);
        }
        Collections.reverse(charList);

        return charList.stream().map(String::valueOf).collect(Collectors.joining());
    }

    //6.
    private static String byIteratingEachCharAndAddingItToFrontOfNewString(String str){
        String newString = "";
        char ch;

        for(int i =0; i<str.length(); i++){
            ch = str.charAt(i);
            newString = ch + newString;
        }
        return newString;
    }
}
