package com.iview.threads.basic;

public class ThreadExampleClass {
    public static void main(String[] args) {
//        MyTask myTask = new MyTask(100);
//        Thread t1 = new Thread(myTask);
//        Thread t2 = new Thread(myTask);
//        Thread t3 = new Thread(myTask);
//
//        t1.start();
//        t2.start();
//        t3.start();

//        MyThread t4 = new MyThread();
//        t4.count = 10;
//        t4.start();
//
//        MyThread t5 = t4;
//        t5.start();
//
//        MyThread t6 = t4;
//        t6.start();


    }
}

class MyThread extends Thread {
    public int count;


    @Override
    public void run() {
        super.run();
        for (int i = 1; i <= count; i++) {
            try {
                System.out.println("Thread : " + Thread.currentThread().getName() +
                        ", i: " + i);

                if (i % 5 == 0) {
                    Thread.sleep(5000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class MyTask implements Runnable {

    public int count;

    public MyTask(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= count; i++) {
            try {
                System.out.println("Thread : " + Thread.currentThread().getName() +
                        ", i: " + i);

                if (i % 5 == 0) {
                    Thread.sleep(5000);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
