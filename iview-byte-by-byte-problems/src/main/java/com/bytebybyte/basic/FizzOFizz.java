
package com.bytebybyte.basic;

/**
 * Output numbers from 1 to x. If the number is divisible by 3, replace it with “Fizz”.
 * If it is divisible by 5, replace it with “Buzz”. If it is divisible by 3 and 5 replace
 * it with “FizzBuzz”.
 */
public class FizzOFizz {

    public static void main(String[] args) {
        fizzOrBizz(20);
    }

    public static void fizzOrBizz(int number) {
        for (int num = 1; num < number; num++)
            if (num % 3 == 0 && num % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (num % 3 == 0) {
                System.out.println("Fizz");
            } else if (num % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(num);
            }
    }
}
