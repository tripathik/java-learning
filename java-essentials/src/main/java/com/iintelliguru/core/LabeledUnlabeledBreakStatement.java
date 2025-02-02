package com.iintelliguru.core;

public class LabeledUnlabeledBreakStatement {
    private void unlabeledBreak(){
        System.out.println("Unlabeled break Statement");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 2) {
                    System.out.println("Inner Loop Until Break: "+j);
                    break; // Breaks out of the inner loop
                }
            }
            System.out.println("Outer Loop Iteration: "+(i+1));
        }
    }
    private void labeledBreakStatement(){
        System.out.println("Unlabeled break Statement");
        System.out.println("Outer Loop");

        outerloop:
        for (int i = 0; i < 3; i++) {
            System.out.println("Outer loop Iteration: "+i+1);
            for (int j = 0; j < 5; j++) {
                System.out.println(i);
                System.out.println(j);
                if (i == 1 && j == 2) {
                    System.out.println(String.format("Before Labeled Break, I: %s, J: %s", i, j));
                    break outerloop; // Breaks out of the outer loop
                }
                System.out.println("Inner loop Iteration: "+j+1);
            }
        }
    }

    public static void main(String[] args) {
        LabeledUnlabeledBreakStatement breakStatement = new LabeledUnlabeledBreakStatement();
        ///breakStatement.unlabeledBreak();
        breakStatement.labeledBreakStatement();
    }
}
