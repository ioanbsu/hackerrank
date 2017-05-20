package com.artigile.day21;

/**
 * Created by ibahdanau on 5/19/17.
 */
public class Printer<T> {
    public void printArray(T[] arrayToPrint) {
        for (T t : arrayToPrint) {
            System.out.println(t);
        }
    }
}
