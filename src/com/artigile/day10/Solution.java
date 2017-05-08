package com.artigile.day10;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int inputValue = in.nextInt();
        final String binaryRepresentation = Integer.toBinaryString(inputValue);
        int maxRepeatedOnes = 0;
        int tempRepeatedOnes = 0;
        for (int i = 0; i < binaryRepresentation.length(); i++) {
            if (binaryRepresentation.charAt(i) == '1') {
                tempRepeatedOnes++;
            } else {
                tempRepeatedOnes = 0;
            }
            if (tempRepeatedOnes > maxRepeatedOnes) {
                maxRepeatedOnes = tempRepeatedOnes;
            }
        }
        System.out.println(maxRepeatedOnes);
    }
}