package com.iintelliguru.core.keywords;

public class StaticClassExample {
    static int num = 10;

    static void staticMethod(){
        System.out.println("Inside the static method, being called from outside of the class without instance being created: Static Variable: "+num);
    }
}
