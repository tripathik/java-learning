package com.iintelliguru.collections.iterators;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class FailFastIterators {

    // Most of the Java Collection Framework classes such as ArrayList, HashSet, HashMap are Fail-Fast.
    // Fail-Fast iterators systems abort operations as fast as possible exposing the failure immediatly and stopping the whole operations.
    // It throw ConcurrentModificationException immediatly as soon they detect any structural modification.
    // It directly access the collection's data structure making them highly sensitive to modification.
    // There are not Thread Safe.
    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Iterator<Integer> iterator = numberList.iterator();

        while(iterator.hasNext()){
            log.info("Item: {}", iterator.next());
            numberList.add(5); // This line will throw ConcurrentModificationexception, since during list is getting modified.
        }
    }
}
