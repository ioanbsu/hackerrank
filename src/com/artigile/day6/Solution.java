package com.artigile.day6;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            final String string = in.next();
            StringBuilder odd = new StringBuilder();
            StringBuilder even = new StringBuilder();
            for (int j = 0; j < string.length(); j += 2) {
                odd.append(string.charAt(j));
                if (string.length() > j + 1) {
                    even.append(string.charAt(j + 1));
                }
            }
            System.out.println(odd + " " + even);
        }
    }
}