package com.artigile.day26;

import java.util.Scanner;

/**
 * Created by ibahdanau on 5/28/17.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int returnDay = sc.nextInt();
        int returnMonth = sc.nextInt();
        int returnYear = sc.nextInt();
        int actualDay = sc.nextInt();
        int actualMonth = sc.nextInt();
        int actualYear = sc.nextInt();

        if (returnYear > actualYear) {
            System.out.println(10000);
        } else if (returnYear == actualYear && returnMonth > actualMonth) {
            System.out.println(500 * (returnMonth - actualMonth));
        } else if (returnYear == actualYear && returnMonth == actualMonth && returnDay > actualDay) {
            System.out.println(15 * (returnDay - actualDay));
        } else {
            System.out.println(0);
        }
    }
}
