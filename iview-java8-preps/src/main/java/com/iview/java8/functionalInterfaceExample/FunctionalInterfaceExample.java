package com.iview.java8.functionalInterfaceExample;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {

        // 1. Bulky way, runnable has only one Method
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("My Runnable");
            }
        };

        // 2. Since it has only one method, we dont need to provide method definitions etc
        Runnable r2 = () -> {
            System.out.println("My Runnable");
        };

        // 3. Pure Lambda version here
        Runnable r3 = () -> System.out.println("My Runnable");


        Thread t1 = new Thread(r1);
        t1.start();
    }
}
