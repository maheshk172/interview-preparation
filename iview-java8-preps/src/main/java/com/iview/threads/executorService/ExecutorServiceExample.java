package com.iview.threads.executorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {

        //ExecutorService service = Executors.newFixedThreadPool(10);
        //ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService service = Executors.newScheduledThreadPool(10);
        List<String> dictionary = new ArrayList<>();

        DictionaryBuilder builder = new DictionaryBuilder(service);
        builder.buildDictionary(10, 6);


    }

    public static void printDictionary() {

    }


}

class DictionaryBuilder {
    ExecutorService service;
    List<String> dictionary = new ArrayList<>();

    public DictionaryBuilder(ExecutorService service) {
        this.service = service;
    }

    public List<String> getDictionary() {
        return dictionary;
    }

    public void buildDictionary(int lengthOfDictionary, int maxLengthOfWords) {

        Runnable runnable = new Runnable() {
            Random random = new Random();

            @Override
            public void run() {
                int lengthOfWord = random.nextInt(maxLengthOfWords);
                if (lengthOfWord == 0) lengthOfWord++;
                StringBuilder builder = new StringBuilder();
                int count = 0;
                for (int j = 65; j <= 90; j++) {
                    if (j % lengthOfWord == 0) {
                        builder.append((char) j);
                        count++;
                    }
                    if (count == maxLengthOfWords)
                        break;
                }
                System.out.println(builder.toString());
                dictionary.add(builder.toString());
            }
        };

        for (int i = 0; i < lengthOfDictionary; i++) {
            this.service.execute(runnable);
        }

        this.service.shutdown();
    }

}

class WordProcessor implements Runnable {
    ExecutorService service;
    List<String> dictionary;

    public WordProcessor(ExecutorService service) {
        this.service = service;
    }

    public void setDictionary(List<String> dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public void run() {


    }
}
