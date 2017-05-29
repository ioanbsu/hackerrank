package com.artigile.day25;

import java.util.Scanner;

/**
 * Created by ibahdanau on 5/28/17.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTests = sc.nextInt();
        for (int i = 0; i < numberOfTests; i++) {
            final int number = sc.nextInt();
            if (!isPrime(number)) {
                System.out.println("Not prime");
            } else {
                System.out.println("Prime");
            }
        }
    }

    private static boolean isPrime(final int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
