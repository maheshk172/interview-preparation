package com.iview.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        for(int i=0; i<100; i++) myList.add(i);

        //sequential stream
        Stream<Integer> sequentialStream = myList.stream();

        //Parallel Stream
        Stream<Integer> parallelStream = myList.parallelStream();

        //Filtering High Numbers
        Stream<Integer> highNumbers = parallelStream.filter(p -> p > 90);

        //using lambda in foreach
        highNumbers.forEach(number -> System.out.println(number));

        //Filtering High Numbers using Sequential list
        Stream<Integer> highNumbersSeq = sequentialStream.filter(p -> p > 90);

        System.out.println("Now in Sequential way-------------------");

        //using lambda in foreach
        highNumbersSeq.forEach(number -> System.out.println(number));
    }
}
