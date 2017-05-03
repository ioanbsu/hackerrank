package com.artigile.day8;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

/**
 * Created by ibahdanau on 5/3/17.
 */
public class Solution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        final Map<String, Integer> phoneBook = new HashMap<>();
        for (int i = 0; i < n; i++) {
            phoneBook.put(in.next(), in.nextInt());
        }
        while (in.hasNext()) {
            String s = in.next();
            final Optional<Integer> phoneNumber = Optional.ofNullable(phoneBook.get(s));
            if (phoneNumber.isPresent()) {
                System.out.println(s + "=" + phoneNumber.get());
            } else {
                System.out.println("Not found");
            }
        }
        in.close();
    }
}
