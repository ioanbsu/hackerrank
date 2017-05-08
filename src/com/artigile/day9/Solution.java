package com.artigile.day9;

import java.util.Scanner;

/**
 * Created by ibahdanau on 5/4/17.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int factorialToCount = in.nextInt();
        System.out.println(factorial(factorialToCount));
    }

    private static int factorial(final int factorialToCount) {
        if (factorialToCount == 1) {
            return 1;
        }
        return factorialToCount * factorial(factorialToCount - 1);
    }
}
