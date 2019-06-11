package com.iview.problems.array;

public class MagicSquareCost {

    public static void main(String[] args) {
        int[][] arr = {{8, 3, 4}, {1, 3, 9}, {6, 7, 2}};

        int cost = calculateCost(arr);
    }

    public static int calculateCost(int[][] arr) {
        int[][] arr1 = new int[][]{
                { 8, 1, 6,},
                { 3, 5, 7, },
                { 4, 9, 2,},
        };

        int[][] arr2 = new int[][]{
                { 6, 1, 8,},
                { 7, 5, 3, },
                { 2, 9, 4,},
        };

        int[][] arr3 = new int[][]{
                { 4, 9, 2,},
                { 3, 5, 7, },
                { 8, 1, 6,},
        };

        int[][] arr4 = new int[][]{
                { 2, 9, 4,},
                { 7, 5, 3, },
                { 6, 1, 8,},
        };

        int[][] arr6 = new int[][]{
                { 8, 3, 4,},
                { 1, 5, 9, },
                { 6, 7, 2,},
        };

        int[][] arr7 = new int[][]{
                { 4, 3, 8,},
                { 9, 5, 1, },
                { 2, 7, 6,},
        };

        int[][] arr8 = new int[][]{
                { 6, 7, 2,},
                { 1, 5, 9, },
                { 8, 3, 4,},
        };

        int[][] arr9 = new int[][]{
                { 2, 7, 6,},
                { 9, 5, 1, },
                { 4, 3, 8,},
        };
        int ans = Integer.MAX_VALUE;

        ans = Math.min(ans, minCostTotal(arr, arr1));
        ans = Math.min(ans, minCostTotal(arr, arr2));
        ans = Math.min(ans, minCostTotal(arr, arr3));
        ans = Math.min(ans, minCostTotal(arr, arr4));
        ans = Math.min(ans, minCostTotal(arr, arr6));
        ans = Math.min(ans, minCostTotal(arr, arr7));
        ans = Math.min(ans, minCostTotal(arr, arr8));
        ans = Math.min(ans, minCostTotal(arr, arr9));

        System.out.println(ans);

        return ans;
    }

    public static int minCostTotal (int [] []arr1, int [] [] arr2){
        int cost = 0;
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                cost += Math.abs(arr1[x][y] - arr2[x][y]);
            }
        }
        return cost;
    }

}
