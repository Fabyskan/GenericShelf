package org.example;

import java.util.Comparator;
import java.util.Iterator;

public class Shelf<T extends ShelfItem> implements Iterable<T> {
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


    public void takeFrom(Shelf<? extends ShelfItem> other) {
    this.upperLeft = (T) other.getUpperLeft();
    this.upperRight = (T) other.getUpperRight();
    this.lowerLeft = (T) other.getLowerLeft();
    this.lowerRight = (T) other.getLowerRight();
    other.upperLeft = null;
    other.upperRight = null;
    other.lowerLeft = null;
    other.lowerRight = null;
    }

//    public T max(Comparator<T> comparator) {
//    T maxItem = null;
//    for(T item : this) {
//        if(item != null) {
//            if(maxItem == null || comparator.compare(item, maxItem) > 0) {
//                maxItem = item;
//            }
//        }
//    }
//    return maxItem;
//    }
//
//    public static void transferAndTrim(Shelf<? extends ShelfItem> from, Shelf<? extends ShelfItem>  to) {
//        to.upperLeft = null;
//        to.upperRight = null;
//        to.lowerLeft = null;
//        to.lowerRight = null;
//        int index = 0;
//        var iterator = to.iterator();
//        if(iterator.hasNext()) {
//        }
//        to.upperLeft = (T) from.getUpperLeft();
//        to.upperRight = (T) from.getUpperRight();
//        to.lowerLeft = (T) from.getLowerLeft();
//        to.lowerRight = (T) from.getLowerRight();
//
//    }
}
