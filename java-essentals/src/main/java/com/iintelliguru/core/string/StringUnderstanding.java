package com.iintelliguru.core.string;

public class StringUnderstanding {
    public void understandStringBuilder_Buffer(){
        StringBuilder sb = new StringBuilder();
        Thread t1 = new Thread(()->{
            for(int i =0; i<1000; i++){
                sb.append("A");
            }
        });
        Thread t2 = new Thread(()->{
            for(int i =0; i<1000; i++){
                sb.append("B");
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (Exception e){
            System.out.println("Exception Occurred: "+e.getMessage());
        }
        System.out.println("StringBuilder ObjectLength: "+sb.toString().length());

        StringBuffer sbf = new StringBuffer();
        Thread t11 = new Thread(()->{
            for(int i =0; i<1000; i++){
                sbf.append("A");
            }
        });
        Thread t22 = new Thread(()->{
            for(int i =0; i<1000; i++){
                sbf.append("B");
            }
        });
        t11.start();
        t22.start();
        try {
            t11.join();
            t22.join();
        }catch (Exception e){
            System.out.println("Exception Occurred: "+e.getMessage());
        }
        System.out.println("StringBuffer ObjectLength: "+sbf.toString().length());

    }

    public void reverseString(String string){
        System.out.println("Reversed Value Using Builder: "+new StringBuilder(string).reverse().toString());
        System.out.println("Reversed Value using Buffer: "+new StringBuffer(string).reverse().toString());
    }
    public void stringFormatting(String name, String designation){
        String result = String.format("My name is %s and my current designation is : %s",name,designation);
        System.out.println(result);
    }

    public static void main(String[] args) {
        StringUnderstanding su = new StringUnderstanding();
        su.understandStringBuilder_Buffer();
        su.reverseString("Krishna");
        su.stringFormatting("Balkrishna Tripathi","Software Engineer");
    }
}
