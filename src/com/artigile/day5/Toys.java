package com.artigile.day5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ibahdanau on 5/1/17.
 */
public class Toys {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfToys = in.nextInt();
        int maxPrice = in.nextInt();
        int[] toysArray = new int[numOfToys];
        for (int i = 0; i < numOfToys; i++) {
            toysArray[i] = in.nextInt();
        }
        Arrays.sort(toysArray);
        int totalPrice = 0;
        int numberOfToys = 0;
        for (int toyPrice : toysArray) {
            if (totalPrice + toyPrice > maxPrice) {
                break;
            }
//            System.out.println("add " + toyPrice);
            totalPrice += toyPrice;
            numberOfToys++;
        }
        System.out.println(numberOfToys);
    }
}
