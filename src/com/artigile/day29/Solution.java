package com.artigile.day29;

import java.util.Scanner;

/**
 * Created by ibahdanau on 5/28/17.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTests = sc.nextInt();
        for (int i = 0; i < numberOfTests; i++) {
            final int N = sc.nextInt();
            final int K = sc.nextInt();
            System.out.println(findMaxBitwise(N, K));
        }
    }

    private static int findMaxBitwise(int n, int k) {
        Integer maxFoundEver = null;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int currentMax = i & j;
                if (maxFoundEver == null) {
                    maxFoundEver = currentMax;
                    continue;
                }
                if (currentMax < k) {
                    maxFoundEver = Math.max(maxFoundEver, currentMax);
                }
            }
        }
        return maxFoundEver;
    }
}
