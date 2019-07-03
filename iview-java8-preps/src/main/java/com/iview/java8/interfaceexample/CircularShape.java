package com.iview.java8.interfaceexample;

public class CircularShape implements ShapeInterface {
    @Override
    public String getShapeColor() {
        return "GREEN";
    }

    @Override
    public String getSize() {
        return "SMALL";
    }
}
