package com.iintelliguru.stream.problems.easy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
public class JoinStringFromList {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

        String allDays = stringList.stream().collect(Collectors.joining(","));
        //OR

        String result = String.join(", ", stringList);
        log.info(allDays);
        log.info("Result: "+result);

        log.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        squareOfNumber();
        extractName();
        convertStringToUpperCase();
        splitStringIntoIndividualChar();
    }

    public static void squareOfNumber(){
        List<Integer> integerNum = Arrays.asList(23, 17, 9, 56, 10, 25, 12);

        List<Integer> squares = integerNum.stream().map(num -> num * num).collect(Collectors.toList());
        log.info(squares.toString());

    }
    public static void extractName(){
        List<Person> persons = Arrays.asList(
                new Person("Krishna", "krishna@example.com", 52000),
                new Person("Tripti", "Tripti@example.com", 51000),
                new Person("Akanksha", "akanksha@example.com", 50000)
        );

        List<String> names = persons.stream()
                .map(Person::getUserName)
                .collect(Collectors.toList());
        log.info(names.toString());
        
    }
    public static void convertStringToUpperCase(){
        List<String> strList = Arrays.asList("radhika", "shyam", "raghav");
        List<String> upperCaseStringList = strList.stream()
                .map(String::toUpperCase).collect(Collectors.toList());
        log.info(String.format("Upper Case String From List: %s", upperCaseStringList));
    }
    public static void splitStringIntoIndividualChar(){
        List<String> stringList = Arrays.asList("vowel","aeiou");

        List<String> charStringList = stringList.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .collect(Collectors.toList());
        log.info(String.format("Each char in each word in list: %s", charStringList));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class Person{
        private String userName;
        private String email;
        private int salary;
    }
}
