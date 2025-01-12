package com.javalearning;

import lombok.Getter;
import lombok.Setter;

public class GenericsInJava {
    public static void main(String[] args) {
        MyGen<Integer> integerGen = new MyGen<>(200);
        System.out.println("Integer Value from Generic class: "+integerGen.get());

        MyGen<String> stringGeneric = new MyGen<>("GENERIC STRING");
        System.out.println("Integer Value from Generic class: "+stringGeneric.get());


        CustomHashMap<String,Integer> ch = new CustomHashMap<>();
        ch.setValue("Table",10);

        int res = ch.getValue();

    }
}
class MyGen<T>{
    private final T obj;
    public MyGen(T obj){
        this.obj=obj;
    }
    public T get(){
        return obj;
    }
}



class CustomHashMap<K,V>{

    @Setter
    private K key;
    @Getter
    private V value;
    void setValue(K key, V value){

        this.key=key;
        this.value=value;
    }
}
