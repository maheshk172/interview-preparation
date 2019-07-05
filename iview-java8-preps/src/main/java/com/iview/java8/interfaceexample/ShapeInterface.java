package com.iview.java8.interfaceexample;

public interface ShapeInterface {

    String getShapeColor();
    String getSize();

    // This can be added without touching existing implementations
    static double getCost() {
        return 10.0;
    }

    default String getName() {
        return "default name";
    }

    default String getShapeName() {
        return "default Shape Name";
    }
}
