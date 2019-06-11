package com.iview.java8.newforloop;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ForLoopExample {

    public static void main(String[] args) {
        //creating sample Collection
        List<Integer> myList = new ArrayList<Integer>();
        for(int i=0; i<10; i++) myList.add(i);


        // 1. anonymous Consumer class
        myList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("forEach anonymous class Value::"+integer);
            }
        });

        // 2. We can use ConsumerClass called MyConsumer as created below
        myList.forEach(new MyConsumer());

        // 3. Consumer can be replaced with Lambda, the statement goes in "Accept" method directly
        myList.forEach(integer -> System.out.println("Using Lambda::"+integer));

    }
}

//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer>{
    public void accept(Integer t) {
        System.out.println("Consumer impl Value::"+t);
    }
}
