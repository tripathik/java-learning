package com.iintelliguru;
public class Main{
    public static void main(String[] args) {
        System.out.println("Simple project for Java Core Concepts");

        int k =0;
        int val = 4;
        int[] num = {1,4,4,6,9,3};
        for(int i =0; i<num.length; i++){
            if(num[i] != val){
                num[k] = num[i];
                k++;
            }
        }
    }
}