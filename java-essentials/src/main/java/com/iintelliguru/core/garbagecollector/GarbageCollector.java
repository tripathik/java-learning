package com.iintelliguru.core.garbagecollector;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GarbageCollector {
    // Process of performing the automatic memory management.
    // Java Runtime Environment will automatically identify the objects which are no longer use and will delete them to free the memory.
    // This automatically unused objects deletion is done through Garbage Collector.

    // Different Algorithm Used for Garbage Collection:
    // 1. Serial GC: Used single thread for garbage collection work. Mostly used in single threaded environment/application.
    // 2. Parallel GC: Used multiple thread to perform the garbage collection work. Mostly Used in multithreaded application.
    // 3. CMS(Concurrently Mask Sweep): Performs most of the garbage collection concurrently with the application threads to minimize the pauses time.
    // 4. G1(Garbage First) GC: Divide the heap into regions and prioritizes reclaiming the regions with the most garbage.
    //    Its used my most of the large applications.

    //Memory Leak: Memory leak happens when there are some object, which no longer used but still referenced, which preventing garbage collector
    //             to reclaiming their memory.
    // This can occurr when some resources are ot closed properly, Some static filed will hold the value and will keep om increasing.
    // Tools like "VisualVM", "JProfiler" and "YourKit" can be used to identify/detect the memory leak, which will identify which of the unused object are not garbage collected.
    private static  final List<String> stringList = new ArrayList<>();
    private void understandGarbageCollector(){
        System.out.println("Creating some dummy Objects");

        for(int i =0; i<5; i++){
            new CustomObject("Created "+i);
        }

        // Objects are being created but no longer used.
    }
    private void memoryLeakByStaticField(){
        while(true){
            stringList.add("SomeData");
        }
        //This will create a memory leak since the static filed is keep on increasing memory
    }
    private void memoryLeakByUnClosedResource() throws IOException {
        File file = new File("some-file.txt");

        FileReader fileReader = new FileReader(file);
        fileReader.read();

        //filereader never closed so this will also create the memory leak
    }

    static  class CustomObject{
        private String name;
        public CustomObject(String name){
            this.name = name;
        }
    }


}
