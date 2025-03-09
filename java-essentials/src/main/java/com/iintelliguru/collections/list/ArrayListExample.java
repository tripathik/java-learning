package com.iintelliguru.collections.list;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ArrayListExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Kiwi");
        fruits.add("Pineapple");

        // Access element by index
        log.info("First element of ArrayList: {}", fruits.get(0));

        // Iterate through the ArrayList
        log.info("ArrayList elements:");
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
