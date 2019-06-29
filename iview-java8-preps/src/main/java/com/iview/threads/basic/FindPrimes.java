package com.iview.threads.basic;

public class FindPrimes {

    public static void main(String[] args) {
     getPrimes(30);
     //   basicCheck();
    }

    public static int[] getPrimes(int n) {
        int[] primes = new int[n];
        int count = 0;
        boolean flag = true;
        for(int i=1; i<n; i++) {

            for(int j=2; j<i; j++) {
                if(i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if(flag == true) {
                //primes.[count++] = i;
                System.out.println(i);
            }
            flag = true;
        }

       // printArray(primes);
        return primes;
    }

    public static void printArray(int[] arr) {
        int count = 0;
        System.out.print("[");
        for(int i : arr){
           System.out.print(i);
           if(count != arr.length - 1)  System.out.print(", ");

           count++;
        }
        System.out.print("]");
    }

    public static void basicCheck() {
        System.out.println(4%3);
        System.out.println(10 / 3);
    }
}

