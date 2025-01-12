package com.iintelliguru.core;

public class PassByValue {
    private static int num = 10;


    public static void main(String[] args) {
        System.out.println("Number before calling the passByValue() method: "+num );
        modifyValue(num);
        System.out.println("Number after calling the passByValue() method: "+num );

        StringBuilder sb = new StringBuilder("Hello ");
        System.out.println("Value before modifyReference(): "+sb);
        modifyReference(sb);
        System.out.println("Value after modifyReference(): "+sb);
    }

    private static void modifyReference(StringBuilder sb) {
        sb.append("World!");
        System.out.println("Inside modifyReference(): "+sb);
    }

    private static void modifyValue(int num) {
        num += 5;
        System.out.println("Inside the passByValue() method: "+num );
    }
}
