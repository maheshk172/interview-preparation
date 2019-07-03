package com.iview.java8.interfaceexample;

public class StaticMethodExample {


    public static void main(String[] args) {
        ShapeInterface shape1 = new BoxShape();
        ShapeInterface shape2 = new CircularShape();

        System.out.println(shape1.getShapeColor());
        System.out.println(shape2.getSize());

        // Accessing it via Static 
        System.out.println(ShapeInterface.getCost());

        // Accessing default methods
        System.out.println(shape1.getName());

        // Accessing default methods
        System.out.println(shape2.getShapeName());

    }
}
