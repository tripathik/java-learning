package com.javalearning;

import java.util.*;

public class CollectionFrameWork {
    List<String> studentList = new ArrayList<>();
    List<String> languageList = new LinkedList<>();
    List<String> daysList = new Vector<>();
    List<String> monthList = new Stack<>();


    public void processLists(){
        studentList.add("John Smith");
        studentList.add("Mark Murphy");
        studentList.add("John Walter");
        studentList.add("Jorge Smith");
        studentList.add("Peter Parker");

        languageList.add("Java");
        languageList.add("C#");
        languageList.add("Python");

        daysList.add("Monday");
        daysList.add("Tuesday");
        daysList.add("Wednesday");

        monthList.add("Jan");
        monthList.add("Feb");
        monthList.add("March");

        System.out.println("Name of the Students are: ");
        for (String name:studentList) {
            System.out.println(name);
        }
        System.out.println("Name of the months are: ");
        Iterator<String> iterator = monthList.iterator();
        while (iterator.hasNext()){
            System.out.printf(iterator.next()+"\n");
        }

    }

    public static void main(String[] args) {
        CollectionFrameWork lc = new CollectionFrameWork();
        lc.processLists();
    }

}
