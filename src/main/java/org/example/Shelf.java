package org.example;

import java.util.Comparator;

public class Shelf {
    private T upperLeft;
    private T upperRight;
    private T lowerLeft;
    private T lowerRight;

    public Shelf() {}

    public Shelf(T uooerLeft, T upperRight, T lowerLeft, T lowerRight) {
        this.upperLeft = uooerLeft;
        this.upperRight = upperRight;
        this.lowerLeft = lowerLeft;
        this.lowerRight = lowerRight;
    }

    public T getUpperLeft() {
        return upperLeft;
    }

    public T getUpperRight() {
        return upperRight;
    }

    public T getLowerLeft() {
        return lowerLeft;
    }

    public T getLowerRight() {
        return lowerRight;
    }

    public T get(int i){}

    public void set(int i, T item) {}

    public void takeFrom(Shelf other) {}

    public T max(Comparator comparator) {}

    public static transferAndTrim(Shelf from, Shelf to) {}
}
