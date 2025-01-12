package com.iintelliguru.core.keywords;


import com.iintelliguru.core.keywords.dto.CustomObject;

abstract class AbstractClass {
    abstract void doSomething();
    public CustomObject doSomething(int age){
        CustomObject customObject = new CustomObject();
        customObject.setAge(age);
        customObject.setName("Developer - 1");
        customObject.setEmail("dev1@test.com");

        return customObject;
    }


}
