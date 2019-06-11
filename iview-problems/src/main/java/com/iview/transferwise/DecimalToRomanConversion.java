package com.iview.transferwise;

import java.util.*;

public class DecimalToRomanConversion {
    public static void main(String[] args) {
        generateMappings();
        String roman = convertRoman(2048);
    }

    public static Map<Integer, String> arabicToRomanMap = new HashMap<>();

    public static String convertRoman(int value) {
//        List<Integer> breakups = getBreakUps(value);
//        String romanValue = getRomanValue(breakups);
//        System.out.println("Roman Value: " + romanValue);

//        String romanValue = getRomanInSimpleWay(value);
//        System.out.println("Roman Value: " + romanValue);
        String romanValue = "MMMDCCXXIV";
        int decimalValue = getDecimalFromNumeral(romanValue);
        System.out.println("Roman Value: " + decimalValue);

        return romanValue;
    }

    public static int getDecimalFromNumeral(String value) {
        final String[] numeralsArray = new String[] {"M","CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        final List<String> numberalList = Arrays.asList(numeralsArray);
        final Integer[] values = new Integer[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final List<Integer> valuesList = Arrays.asList(values);

        int i = 0;
        int totalCount = 0;
        for(int j=0; j<value.length();) {
            if(j <= value.length() - 2) {
                String firstTwoChars = value.substring(j, j+2);
                int indexInList = numberalList.indexOf(firstTwoChars);
                if(indexInList >= 0) {
                    totalCount = totalCount + valuesList.get(indexInList); 
                    indexInList = numberalList.indexOf(firstChar);
                    if(indexInList >= 0) {
                        totalCount = totalCount + valuesList.get(indexInList);
                        j = j + 1;
                    } else {
                        throw new IllegalArgumentException("Its not a roman String");
                    }
                }
            } else {
                String firstChar = value.substring(j, j+1);
                int indexInList = numberalList.indexOf(firstChar);
                if(indexInList >= 0) {
                    totalCount = totalCount + valuesList.get(indexInList);
                    j = j + 1;
                } else {
                    throw new IllegalArgumentException("Its not a roman String");
                }
            }
        }

        return totalCount;
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

    public static String getRomanValue(List<Integer> breakups) {
        StringBuffer buffer = new StringBuffer();

        for(Integer i : breakups) {
            if(i.intValue() <= 10) {
                if(arabicToRomanMap.containsKey(i) == true) {
                    String arabicValue = arabicToRomanMap.get(i);
                    buffer.append(arabicValue);
                } else {
                    if(i.intValue() < 5) {
                        for(int j=0; j<1; j++) {
                            buffer.append(arabicToRomanMap.get(1));
                        }
                    } else {
                        String one = arabicToRomanMap.get(1);
                        String five = arabicToRomanMap.get(5);
                        buffer.append(five);
                        for(int j=0; j < i-5; j++) {
                            buffer.append(one);
                        }
                    }
                }
            }else if(arabicToRomanMap.containsKey(i) == true) {
                String arabicValue = arabicToRomanMap.get(i);
                buffer.append(arabicValue);
            } else {
                int firstChar = new Integer("" + i.toString().charAt(0));
                int arabicKey = i/firstChar;
                String arabicValue = arabicToRomanMap.get(arabicKey);

                for(int j=0; j<firstChar; j++) {
                    buffer.append(arabicValue);
                }
            }
        }

        return buffer.toString();
    }

    public static void generateMappings() {

        arabicToRomanMap.put(1, "I");
        arabicToRomanMap.put(2, "II");
        arabicToRomanMap.put(3, "III");
        arabicToRomanMap.put(4, "IV");
        arabicToRomanMap.put(5, "V");
        arabicToRomanMap.put(9, "IX");
        arabicToRomanMap.put(10, "X");
        arabicToRomanMap.put(40, "XL");
        arabicToRomanMap.put(50, "L");
        arabicToRomanMap.put(100, "C");
        arabicToRomanMap.put(500, "D");
        arabicToRomanMap.put(900, "CM");
        arabicToRomanMap.put(1000, "M");
    }

    public static List<Integer> getBreakUps(int value) {
        List<Integer> breakUps = new ArrayList<>();
        double decimal = 10;
        int tempVal = value;

        while(tempVal > 0) {
            double length = ("" + tempVal).length() - 1;
            double divider = Math.pow(decimal, length);

            double remainder = tempVal % divider;
            double quotient = Math.floor(tempVal / divider);

            breakUps.add(new Integer(((int)(quotient * divider))));
            tempVal = (int) remainder;
        }

        System.out.println(breakUps.toString());
        return breakUps;
    }





}
