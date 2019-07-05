package com.iview.liftmanagement;

public class LiftRequest {
    final int floor;
    final LiftDirections direction;

    public LiftRequest(int floor, LiftDirections direction) {
        this.floor = floor;
        this.direction = direction;
    }
}
