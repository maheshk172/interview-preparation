package com.bytebybyte.basic;

public class SwapValues {
    public static void main(String[] args) {

        int a = 10;
        int b = 5;
        int[] arr = new int[2];
        arr[0] = a;
        arr[1] = b;

//        System.out.println("Before Swap");
//        System.out.println("a: " + arr[0] + ", b: " + arr[1]);
//        //swap(a, b);
//        swapValues(arr);
//        System.out.println("after Swap");
//
//        System.out.println("a: " + arr[0] + ", b: " + arr[1]);
        SwapNode node = new SwapNode(a, b);

        System.out.println("Before swapValuesUsingObject");
        System.out.println("a: " + node.a + ", b: " + node.b);
        swapValuesUsingObject(node);
        System.out.println("After swapValuesUsingObject");
        System.out.println("a: " + node.a + ", b: " + node.b);


    }

    public static void swapValuesUsingObject(SwapNode node){
        System.out.println("Inside swapValuesUsingObject - before swap");
        System.out.println("a: " + node.a + ", b: " + node.b);
        node.a = node.a + node.b;
        node.b = node.a - node.b;
        if(node.b < 0) {
            node.b = node.b * -1;
        }


        node.a = node.a - node.b;
        if(node.a < 0) {
            node.a = node.a * -1;
        }
        System.out.println("Inside swapValuesUsingObject - After swap");
        System.out.println("a: " + node.a + ", b: " + node.b);
    }



    public static void swapValues(int[] arr){
        System.out.println("Inside SwapValues - before");
        System.out.println("a: " + arr[0] + ", b: " + arr[1]);
        arr[0] = arr[0] + arr[1];
        arr[1] = arr[0] - arr[1];
        if(arr[1] < 0) {
            arr[1] = arr[1] * -1;
        }


        arr[0] = arr[0] - arr[1];
        if(arr[0] < 0) {
            arr[0] = arr[0] * -1;
        }
        System.out.println("Inside SwapValues - After");
        System.out.println("a: " + arr[0] + ", b: " + arr[1]);
    }
}

class SwapNode {
    public int a;
    public int b;

    public SwapNode(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
