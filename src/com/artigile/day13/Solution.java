package com.artigile.day13;

import java.util.Scanner;

/**
 * Created by ibahdanau on 5/8/17.
 */
 public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int price = scanner.nextInt();
        scanner.close();

        Book book = new MyBook(title, author, price);
        book.display();
    }
}