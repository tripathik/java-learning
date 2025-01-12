package com.javalearning;

import org.apache.el.stream.Stream;

import java.util.HashMap;

public class FindCahareteOccurrences {
    public static void main(String[] args) {
        String str = "I am Java developer";
        char charToFind = 'e';
        long frequency = str.chars().mapToObj(c->(char)c).filter(c->c==charToFind).count();
    }

}

