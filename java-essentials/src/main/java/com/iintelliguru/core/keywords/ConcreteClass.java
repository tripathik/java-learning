package com.iintelliguru.core.keywords;

public class ConcreteClass extends AbstractClass{
    @Override
    void doSomething() {
        System.out.println("Called abstract() method from based/concrete class after implementing it.");
    }
}
