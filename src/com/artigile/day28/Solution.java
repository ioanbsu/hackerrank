package com.artigile.day28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ibahdanau on 5/28/17.
 */
public class Solution {
    private static final Pattern emailsPattern = Pattern.compile("([a-z]*) [a-z.]+@gmail.com");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int emailsQuantity = sc.nextInt();
        List<String> people = new ArrayList<>();
        for (int i = 0; i <= emailsQuantity; i++) {
            String nameEmailStr = sc.nextLine();
            Matcher matcher = emailsPattern.matcher(nameEmailStr);
            if (matcher.matches()) {
                people.add(matcher.group(1));
            }
        }
        Collections.sort(people);
        for (String person : people) {
            System.out.println(person);
        }
    }
}
