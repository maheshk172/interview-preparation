package com.iview.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateSubArraysWithDifferenceOne {

    public static void main(String[] args) {

        Integer[] arr = {1, 1, 2, 2, 3, 4};
        List<Integer> list = convertArrayToList(arr);
        System.out.println("Main Array :" + list);

        int totalLength = pickingNumbers(list);
        System.out.println("Max Length : " + totalLength);
    }

    // Generic function to convert an Array to List
    public static <T> List<T> convertArrayToList(T array[]) {

        // Create the List by passing the Array
        // as parameter in the constructor
        List<T> list = Arrays.asList(array);

        // Return the converted List
        return list;
    }


    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        int length = a.size();
        int maxLength = 0;

        for (int i = 0; i < length; i++) {
            int pivot = a.get(i);
            List<Integer> subArray = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                if (Math.abs(pivot - a.get(j)) == 1 || Math.abs(pivot - a.get(j)) == 0) {

                    int jValue = a.get(j);
                    boolean flag = true;
                    for (int k = 0; k < subArray.size(); k++) {
                        if (Math.abs(subArray.get(k) - jValue) != 1 && Math.abs(subArray.get(k) - jValue) != 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag == true) {
                        subArray.add(jValue);
                    }
                }
            }

            System.out.println(subArray);
            if (subArray.size() > maxLength) {
                maxLength = subArray.size();
            }
        }

        return maxLength;
    }
}
