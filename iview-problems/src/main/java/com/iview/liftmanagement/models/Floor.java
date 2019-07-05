package com.iview.liftmanagement.models;

import com.iview.liftmanagement.LiftDirections;

public class Floor implements Comparable<Floor> {
    final Integer floorNo;
    final LiftDirections direction;

    public Floor(Integer floorNo, LiftDirections direction) {
        this.floorNo = floorNo;
        this.direction = direction;
    }

    @Override
    public int compareTo(Floor o) {
        if(this.floorNo < o.floorNo) {
            return 1;
        } else {
            return 0;
        }
    }
}
