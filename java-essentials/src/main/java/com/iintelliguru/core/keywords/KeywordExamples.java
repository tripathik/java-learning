package com.iintelliguru.core.keywords;

public class KeywordExamples {
    public static void main(String[] args) {
        System.out.println("Static variable got accessed outside of the class directly: "+ StaticClassExample.num);
        StaticClassExample.staticMethod();

        ConcreteClass concreteClass = new ConcreteClass();
        concreteClass.doSomething();

        FinalClass finalClass = new FinalClass();
        //finalClass.string = "Trying to Modify in outer class"
        System.out.println("Final class member: "+finalClass.string);
        finalClass.doSomething();

    }
}
