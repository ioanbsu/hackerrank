package com.artigile.day16;

import java.util.Scanner;

/**
 * Created by ibahdanau on 5/11/17.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        try {
            System.out.println(Integer.parseInt(S));
        } catch (NumberFormatException e) {
            System.out.println("Bad String");
        }

    }
}
