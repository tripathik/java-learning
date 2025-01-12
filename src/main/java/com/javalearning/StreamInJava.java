package com.javalearning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamInJava {
    private static void processStream(){
        List<Integer> number = Arrays.asList(2, 3, 4, 5);

        //map()
        List<Integer> square= number.stream().map(x -> x * x).collect(Collectors.toList());

        //filter()
        square= square.stream().filter(ch->ch%2==0).collect(Collectors.toList());
        List<Integer> integerList;
        square.stream().forEach(x->{
            int y = x+10;
            System.out.println(y);
        });
    }

    public static void main(String[] args) {
        processStream();
    }
}
