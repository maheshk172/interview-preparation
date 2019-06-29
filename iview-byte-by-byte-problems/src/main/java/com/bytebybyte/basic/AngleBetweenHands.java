package com.bytebybyte.basic;

/**
 * Given a time, write a function to find the angle between
 * the two hands on a clock representing that time.
 *  3:40 => 110
 *
 */
public class AngleBetweenHands {
    public static void main(String[] args) {
        calculateClockAngle(3, 14);
        calculateClockAngle(12, 1);
        calculateClockAngle(1, 50);
    }

    private static void calculateClockAngle(int hour, int min) {
        int minPerHour = 60;
        int degreePerMin = 360/minPerHour;
        int degreePerHour = 360/12;

        hour = hour % 12;

        int minuteAngle = min * degreePerMin;
        int hourAngle = hour * degreePerHour + ((min/minPerHour) * degreePerHour);

        int diff = Math.abs(minuteAngle - hourAngle);
        if(diff > 180){
            diff = 360 - diff;
        }
        System.out.println("Angle between [" + hour + ":" + min + "] is : " + diff);
    }

}
