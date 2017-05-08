package com.artigile.day11;

import java.util.Scanner;

/**
 * Created by ibahdanau on 5/7/17.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        Integer maxHourGlass = null;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int thisHourGlass = calculateHourglass(i, j, arr);
                if (maxHourGlass == null) {
                    maxHourGlass = thisHourGlass;
                    continue;
                }
                if (thisHourGlass > maxHourGlass) {
                    maxHourGlass = thisHourGlass;
                }
            }
        }
        System.out.println(maxHourGlass);
    }

    private static int calculateHourglass(int i, int j, int[][] arr) {
        return arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] +
            arr[i + 2][j + 2];
    }
}
