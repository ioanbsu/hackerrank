package com.artigile.day9;

import java.util.Scanner;

/**
 * Created by ibahdanau on 5/4/17.
 */
public class JumpingClouds {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for (int c_i = 0; c_i < n; c_i++) {
            c[c_i] = in.nextInt();
        }
        int currentPosition = 0;
        int steps = 0;
        while (currentPosition < n - 1) {
            steps++;
            int maxJump = Math.min(2, n - currentPosition - 1);
            while (maxJump > 0) {
                if (c[currentPosition + maxJump] == 0) {
                    currentPosition += maxJump;
                    break;
                }
                maxJump--;
            }
        }
        System.out.println(steps);
    }

}
