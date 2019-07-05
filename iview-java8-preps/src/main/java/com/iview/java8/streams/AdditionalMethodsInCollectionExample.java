package com.iview.java8.streams;

import java.util.*;

public class AdditionalMethodsInCollectionExample {
    public static void main(String[] args) {
        /**
         * First Example
         */
        // List<Integer> myList = new ArrayList<>();
        // for(int i=0; i<21; i++) myList.add(i);

        //Iterator<Integer> iterator = myList.iterator();
        // Iterator -> forEachRemaining
        // iterator.forEachRemaining(item -> System.out.println("Item Name: " + item));

        // Collection c = myList;
        //Collection -> removeIf method
        // c.removeIf(item -> ((Integer)item) % 4 == 0 );
        // c.forEach(item -> System.out.println("Item Name: " + item));

        /**
         *  Second example
         */
         List<String> myList = new ArrayList<>();
         for(int i=9; i<200; i++) myList.add("Number: " + i);

        Map<String, Integer> numberMap = new HashMap<>();
        myList.forEach(item -> numberMap.put(item, item.length()));

        

    }
}
