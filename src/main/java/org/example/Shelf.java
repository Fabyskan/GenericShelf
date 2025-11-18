package org.example;


public class Shelf<T extends Iterable<T>> {
    private T upperLeft;
    private T upperRight;
    private T lowerLeft;
    private T lowerRight;

    public Shelf() {
        upperLeft = null;
        upperRight = null;
        lowerLeft = null;
        lowerRight = null;
    }

    public Shelf(T upperLeft, T upperRight, T lowerLeft, T lowerRight) {
        this.upperLeft = upperLeft;
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

    public static void transferAndTrim(Shelf from, Shelf to) {}
}
