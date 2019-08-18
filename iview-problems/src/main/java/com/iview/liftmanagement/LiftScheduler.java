package com.iview.liftmanagement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class LiftScheduler extends Thread{
    private  Lift[] lifts;
    private  Queue<LiftRequest> schedulerQueue = new LinkedList<>();
    private  boolean keepLiftsRunning = true;
    private  boolean isLiftRunning = false;

    public  void startScheduler(int numberOflifts) {
        if(isLiftRunning) {
            return;
        }

        lifts = new Lift[numberOflifts];
        isLiftRunning = true;

        int count = 1;
        // Starting all Lifts
        for(Lift lift: lifts) {
            lift = new Lift("Lift-" + count);
            lift.setDiretion(LiftDirections.UP);
            lift.setKeepLiftRunning(true);
            lifts[count-1] = lift;
            count++;
            Thread t = new Thread(lift);
            t.start();
        }

        this.start();
    }


    @Override
    public void run() {
        //Start processing the requests
        while(keepLiftsRunning == true) {
            // checking for the lift
            if(schedulerQueue.isEmpty()) {
                System.out.println("The Lift Request Queue is empty...");
            } else {
                LiftRequest liftRequest = schedulerQueue.remove();
                processFloorRequest(liftRequest);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    // Button is pushed to request a Lift
    public  void floorRequest(int floor, LiftDirections direction) {
        LiftRequest request = new LiftRequest(floor, direction);
        schedulerQueue.add(request);
        System.out.println("Added Floor: [" + floor + "], direction: [" + direction + "] request in liftQueue");
    }


    private  void processFloorRequest(LiftRequest liftRequest) {
        Lift matchedLift = findBestMatchedLift(liftRequest.floor, liftRequest.direction);
        if(matchedLift == null) {
            System.out.println("Glitch happened, unable to find closest Lift");
        } else {
            matchedLift.addRequestedFloor(liftRequest.floor, liftRequest.direction);
            System.out.println("Lift [" + matchedLift.getLiftName() + "], is closest and reach on floor: [" + liftRequest.floor + "] shortly");
        }
    }

    private  Lift findBestMatchedLift(int floor, LiftDirections direction) {
        Lift[] filterdLiftsByDirection = getLiftsWithDirection(direction);
        return getClosestLift(floor, filterdLiftsByDirection);
    }

    private  Lift[] getLiftsWithDirection(LiftDirections direction) {
        ArrayList<Lift> tempLifts = new ArrayList<>();
        for(Lift lift: lifts) {
            if(lift.getDirection() == direction) {
                tempLifts.add(lift);
            }
        }
        if(tempLifts.size() > 0) {
            Lift[] filteredLifts = new Lift[tempLifts.size()];
            tempLifts.toArray(filteredLifts);
            return filteredLifts;
        } else {
            // THIS IS A HACK, SOMEHOW THE LIFT IS NOT SETTING THE DEFAULT DIRECTIONS
            Lift[] filteredLifts = new Lift[1];
            filteredLifts[0] = lifts[new Random().nextInt(3)];
            return filteredLifts;
        }

    }

    private  Lift getClosestLift(int floor, Lift[] filteredLifts) {

        Lift smallest =  filteredLifts[0];
        int smallestDiff = Math.abs(filteredLifts[0].getCurrentFloor() - floor);

        for(int i=1; i<filteredLifts.length; i++) {
            if( Math.abs(filteredLifts[i].getCurrentFloor() - floor) < smallestDiff) {
                smallestDiff = Math.abs(filteredLifts[1].getCurrentFloor() - floor);
                smallest = filteredLifts[i];
            }
        }

        return smallest;
    }



}
