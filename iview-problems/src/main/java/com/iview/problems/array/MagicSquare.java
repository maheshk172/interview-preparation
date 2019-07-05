package com.iview.problems.array;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class MagicSquare {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] arr) {
        //Create HashMapOfValues
        Map<Integer, Integer> map = new HashMap<>();
        int i, j=0;
        int n = arr[0].length;

        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                if(map.containsKey(arr[i][j])) {
                    map.put(arr[i][j], map.get(arr[i][j]) + 1);
                } else {
                    map.put(arr[i][j], 1);
                }
            }
        }

        //find culprit
        int culprit = findCulprit(map);
        // if array length = 3, then total elements = 9 (n*n)
        int missingKey = FindMissingKey(map, n*n);


        // Try to create magicSquare
        int[][] tempArray = arr;
        boolean stopFlag = false;
        for(i=0; i<n && stopFlag == false; i++) {
            for(j=0; j<n; j++) {
                if(arr[i][j] == culprit) {
                    // replacing only for testing
                    arr[i][j] = missingKey;
                    if (checkIfItsMagicSquare(arr) == true) {
                        System.out.println("Now the square This is a magic Square");
                        stopFlag = true;
                        break;
                    } else {
                        System.out.println("This square is not a magic Square");
                    }
                }
            }
        }



        return 0;
    }

    static int FindMissingKey(Map<Integer, Integer> map, int n) {
        int missingKey = 0;
        boolean flag = false;
        Set<Integer> set = map.keySet();
        for(int i=1; i<=n && flag == false; i++) {
            if(!set.contains(i)) {
                flag = true;
                missingKey = i;
            }
        }


        if(flag == true) {
            System.out.println("Missing Key is : " + missingKey);
        } else {
            System.out.println("There is no missing key");
        }

        return missingKey;
    }


    static int findCulprit(Map<Integer, Integer> map) {
        AtomicInteger culprit = new AtomicInteger();
        AtomicBoolean flag = new AtomicBoolean(false);
        map.keySet().forEach(key -> {
            int value = map.get(key).intValue();
            if(value > 1) {
                culprit.set(key);
                flag.set(true);
            }
        });
        if(flag.get() == true) {
            System.out.println("Culprit is : " + culprit.get());
        } else {
            System.out.println("There is no culprit");
        }

        return culprit.get();
    }

    static boolean checkIfItsMagicSquare(int[][] arr) {
        int n = arr[0].length;
        int[] rowSums = new int[n];
        int leftDiagonalAddition = 0;
        int rightDiagonalAddition = 0;

        int i = 0;
        // RightDiagonaAddition
        for (i = 0; i < n; i++) {
            rightDiagonalAddition = rightDiagonalAddition + arr[i][i];
        }

        // leftDiagonaAddition
        for (i = n - 1; i >= 0; i--) {
            leftDiagonalAddition = leftDiagonalAddition + arr[i][i];
        }

        // VariousRows
        for (i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSums[i] = rowSums[i] + arr[i][j];
            }
        }
        boolean isMagicSquare = true;
        //Verify if its a magixSquare
        i = 0;
        int j = 0;
        for (i = 0; i < rowSums.length && isMagicSquare == true; i++) {
            for (j = i + 1; j < rowSums.length; j++) {
                if (rowSums[i] != rowSums[j] || rowSums[i] != leftDiagonalAddition || rowSums[i] != leftDiagonalAddition) {
                    isMagicSquare = false;
                    break;
                }
            }
        }

        if (isMagicSquare == true) {
            System.out.println("Each Row Sum is : " + leftDiagonalAddition);
        } else {
            System.out.println("Row Counts does not match");
        }

        return isMagicSquare;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // This is a perfect Magic Square
        int[][] square = {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}};
//        if (checkIfItsMagicSquare(square) == true) {
//            System.out.println("square This is a magic Square");
//        } else {
//            System.out.println("square This is not a magic Square");
//        }
        // formingMagicSquare(square);

        //This is not a Magic Square
        int[][] square1 = {{8, 3, 4}, {1, 3, 9}, {6, 7, 2}};
//        if (checkIfItsMagicSquare(square1) == true) {
//            System.out.println("square1 This is a magic Square");
//        } else {
//            System.out.println("square1 This is not a magic Square");
//        }
        formingMagicSquare(square1);

    }
}
