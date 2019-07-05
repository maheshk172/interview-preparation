package com.bytebybyte.stackusages;

import java.util.Arrays;

public class StackWithArrayExample {
    public static void main(String[] args) {
        Stack stack = new Stack();

        for(int i=1; i<30; i++) {
            stack.push(10 + i);
        }
    }
}

class Stack {
    private int baseSize = 10;
    private int incrementCounter = 1;
    int[] stackArray = new int[baseSize * incrementCounter];
    int top = -1;

    public synchronized void push(int data) {
        top++;

        if ((baseSize * incrementCounter) * 90 / 100 > top) {
            stackArray[top] = data;
        } else {

            System.out.println("array seem to be 90% full, extending array");
            extendArray();
            stackArray[top] = data;
        }
        System.out.println("Pushed : " + data);
    }

    public int pop() {
        int item = stackArray[top];
        top--;
        System.out.println("Popped : " + item);
        return item;
    }

    private synchronized void extendArray() {
        System.out.println("Waiting for the array Extending");
        incrementCounter++;
        int[] newStackArray;
        newStackArray = Arrays.copyOf(this.stackArray, baseSize * incrementCounter);
        this.stackArray = newStackArray;
        System.out.println("array Extending finished");
    }
}
