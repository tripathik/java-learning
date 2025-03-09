package com.iintelliguru.collections.list;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> fruits = new LinkedList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Kiwi");
        fruits.add("Pineapple");

        // Access element by index
        log.info("First element of LinkedList: {}", fruits.get(0));

        // Iterate through the ArrayList
        log.info("LinkedList elements:");
        for (String fruit : fruits) {
            log.info(fruit);
        }


        fruits.remove(1); // Removes "Banana"
        log.info("After removal:");
        for (String fruit : fruits) {
            log.info(fruit);
        }
    }
}
