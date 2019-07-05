package com.iview.liftmanagement;

import java.util.PriorityQueue;

public class Lift implements Runnable {
    private int currentFloor = 0;
    private LiftDirections direction = LiftDirections.UP;
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    private boolean keepLiftRunning = true;
    private String liftName;

    public Lift(String liftName) {
        this.liftName = liftName;
    }

    @Override
    public void run() {
        while(keepLiftRunning == true) {
            if(!queue.isEmpty()) {
                currentFloor = queue.remove();
                System.out.println("Lift: [" + liftName + "] has reached on floor : [" + currentFloor
                        + "] and current direction: [" + direction + "]");
            } else {
                System.out.println("Lift: [" + liftName + "] is still on floor : [" + currentFloor
                        + "]");
                direction = null;
            }

            try {
                Thread.sleep(5000);
                System.out.println("Lift: [" + liftName + "] Timer sleeping for 1 second");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public LiftDirections getDirection() {
        return direction;
    }

    public void setDiretion(LiftDirections direction) {
        this.direction = direction;
    }

    public boolean isKeepLiftRunning() {
        return keepLiftRunning;
    }

    public void setKeepLiftRunning(boolean keepLiftRunning) {
        this.keepLiftRunning = keepLiftRunning;
    }

    public void addRequestedFloor(int floor, LiftDirections direction) {
        this.queue.add(floor);
        if(this.direction != direction) {
            this.direction = direction;
        }
    }

    public String getLiftName() {
        return this.liftName;
    }
}
