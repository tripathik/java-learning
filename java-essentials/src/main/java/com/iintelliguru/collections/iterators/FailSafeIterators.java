package com.iintelliguru.collections.iterators;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class FailSafeIterators {
    // It does not throw any exception while collections is being modified during iteration
    // Instead its uses the copy/clone or snapshot of the collection's data at the time iterator was created.
    // iterator of concurrent collections such as CopyObWriteArrayList, ConcurrentHashMap are Fail-Safe
    // Thread Safe.
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> words = new CopyOnWriteArrayList<>(Arrays.asList("Apple", "Banana", "Cat"));
        Iterator<String> iterator = words.iterator();

        while(iterator.hasNext()){
            log.info("Word: {}", iterator.next());

            words.add("Krishna");
        }
        log.info("Total List Item: {}", words);
    }
}
