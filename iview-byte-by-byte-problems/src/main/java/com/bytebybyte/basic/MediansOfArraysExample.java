package com.bytebybyte.basic;

public class MediansOfArraysExample {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {0, 0 , 0, 10, 10};

        double median = calculateMedian(arr1, arr2);
        System.out.println(median);
    }

    public static double calculateMedian(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length || arr1.length == 0 || arr2.length == 0) {
            throw new IllegalArgumentException("Arrays are not of same size");
        }
        return calculateMedian(SubArray.fromArray(arr1), SubArray.fromArray(arr2));
    }

    public static double calculateMedian(SubArray arr1, SubArray arr2) {
        if(arr1.getSize() == 1) {
            return (arr1.getFirst() + arr2.getFirst()) / 2;
        }

        if(arr1.getSize() == 2) {
            return (Math.max(arr1.getFirst(), arr2.getFirst()) +
                    Math.min(arr1.getLast(), arr2.getLast())) / 2;
        }

        double median1 = arr1.getMedian();
        double median2 = arr2.getMedian();
        // For the array with the greater median, we take the bottom half of
        // that array and the top half of the other array

        if(median1 > median2) {
            return calculateMedian(arr1.getSubArray(0, arr1.getSize() / 2 + 1),
                    arr2.getSubArray((arr2.getSize() - 1) / 2, arr2.getSize()));

        }

        return calculateMedian(arr1.getSubArray((arr1.getSize() - 1) / 2, arr1.getSize()),
                arr2.getSubArray(0, arr2.getSize() / 2 + 1));


    }
}


class SubArray {
    private int[] underlying;
    private int start;
    private int size;

    public static SubArray fromArray(int[] arr) {
        SubArray subArray = new SubArray();
        subArray.underlying = arr;
        subArray.start = 0;
        subArray.size = arr.length;
        return subArray;
    }

    public SubArray getSubArray(int i, int j) {
        if(i > j) throw  new IllegalArgumentException();
        if(j > this.size) throw new ArrayIndexOutOfBoundsException();

        SubArray subArray = new SubArray();
        subArray.underlying = this.underlying;
        subArray.start = start + i;
        subArray.size = j - i;
        return subArray;
    }

    public int getStart() { return start; }

    public int getSize() { return size; }

    public int getFirst() { return underlying[start]; }

    public int getLast() { return underlying[start + size - 1]; }

    public double getMedian() {
        if(size % 2 == 0) {
            return ((underlying[start + size/2] - 1) + (underlying[start + size/2]))/2;
        }
        return underlying[start + size/2];
    }



}
