package org.example;

import java.util.Comparator;
import java.util.Iterator;

public class Shelf<T extends Shelfitem> implements Iterable<T> {
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

public void setUpperLeft(T item) {
    this.upperLeft = item;
}

public void setUpperRight(T item) {
    this.upperRight = item;
}

public void setLowerLeft(T item) {
    this.lowerLeft = item;
}

public void setLowerRight(T item) {
    this.lowerRight = item;
}


@Override
public Iterator<T> iterator() {
    return new Iterator<T>() {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < 4;
        }

        @Override
        public T next() {
            if(!hasNext()) {
                throw new java.util.NoSuchElementException("No such element.");
            }
            return switch (index++) {
                case 0 -> upperLeft;
                case 1 -> upperRight;
                case 2 -> lowerLeft;
                case 3 -> lowerRight;
                default -> null;
            };
        }
    };
}


    public T get(int i) {
        if (i > 3 || i < 0) {
            throw new IndexOutOfBoundsException("Index must be between 0 and 3.");
        }
        return switch (i) {
            case 0 -> upperLeft;
            case 1 -> upperRight;
            case 2 -> lowerLeft;
            case 3 -> lowerRight;
            default -> throw new IllegalStateException("Unexpected value");
        };
    }

    public void set(int i, T item) {
    if(i > 3 || i < 0) {
    throw new IndexOutOfBoundsException("Index must be between 0 and 3.");}
    switch(i) {
        case 0 -> upperLeft = item;
        case 1 -> upperRight = item;
        case 2 -> lowerLeft = item;
        case 3 -> lowerRight = item;
        default -> throw new IllegalStateException("Unexpected value");
    }
}

//
//    public void takeFrom(Shelf other) {}
//
//    public T max(Comparator comparator) { return null; }
//
//    public static void transferAndTrim(Shelf from, Shelf to) {}
}
