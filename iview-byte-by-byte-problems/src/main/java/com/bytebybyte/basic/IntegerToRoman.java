package com.bytebybyte.basic;

// Given an integer, write a function to return its roman numeral representation

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(getRomanInSimpleWay(8));
    }

    public static String getRomanInSimpleWay(int value) {
        StringBuilder builder = new StringBuilder();

        final String[] numerals = new String[] {"M","CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        final int[] values = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        if(value > 3999 || value < 1) throw new IllegalArgumentException();

        int i = 0;
        while (value > 0) {
            if(value - values[i] >= 0) {
                builder.append(numerals[i]);
                value = value - values[i];
            } else {
                i++;
            }
        }

        return builder.toString();
    }


}
