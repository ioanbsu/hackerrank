package com.artigile.day14;

import java.util.Objects;

/**
 * Created by ibahdanau on 5/10/17.
 */
public class Difference {
    public int maximumDifference;
    private int[] elements;

    public Difference(int[] elements) {
        this.elements = elements;
    }

    public void computeDifference() {
        Integer evaludatedMaxDiff = null;
        for (int i = 0; i < elements.length; i++) {
            for (int j = i + 1; j < elements.length; j++) {
                final int currentDiff = Math.abs(elements[i] - elements[j]);
                if (evaludatedMaxDiff == null) {
                    evaludatedMaxDiff = currentDiff;
                } else if (currentDiff > evaludatedMaxDiff) {
                    evaludatedMaxDiff = currentDiff;
                }
            }
        }
        maximumDifference = evaludatedMaxDiff;
    }
}
