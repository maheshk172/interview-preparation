package com.iview.java8.interfaceexample;

public class BoxShape implements ShapeInterface {
    @Override
    public String getShapeColor() {
        return "Red";
    }

    @Override
    public String getSize() {
        return "BIG";
    }
}
