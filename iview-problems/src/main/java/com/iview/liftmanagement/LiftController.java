package com.iview.liftmanagement;

import java.util.Random;

public class LiftController {

    public static void main(String[] args) {
        LiftScheduler scheduler = new LiftScheduler();
        scheduler.startScheduler(3);

        Thread t1 = new Thread(new LiftRequestSender(scheduler));
        Thread t2 = new Thread(new LiftRequestSender(scheduler));
        Thread t3 = new Thread(new LiftRequestSender(scheduler));
        Thread t4 = new Thread(new LiftRequestSender(scheduler));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}

class LiftRequestSender implements Runnable {
    LiftScheduler scheduler;
    Random  random = new Random();

    public LiftRequestSender(LiftScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (this) {
                scheduler.floorRequest(random.nextInt(10), getRandomDirection());
            }

            try {
                Thread.sleep(random.nextInt(10) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized LiftDirections getRandomDirection() {
        if(random.nextInt(2) == 1) {
            return LiftDirections.UP;
        } else {
            return LiftDirections.DOWN;
        }
    }
}