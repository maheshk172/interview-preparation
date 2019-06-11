package com.iview.java8.functionalInterfaceExample;

public interface MyRunnableInterface {
    default void run() {
        System.out.println("This is abstact Runnable");
    }
}
