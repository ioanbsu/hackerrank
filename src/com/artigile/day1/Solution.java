package com.artigile.day1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static LettersStateMachine knownWords;
//    private static Set<String> knownWords;

    public static void main(String[] args) {
//        knownWords = new LettersStateMachine();
//        System.out.println(calculateMinimumPrice(4, 5, "aabaacaba"));
//        knownWords = new LettersStateMachine();
//        System.out.println(calculateMinimumPrice(8, 9, "bacbacacb"));

        Scanner in = new Scanner(System.in);
        int numOfTestCases = in.nextInt();
        for (int i = 0; i < numOfTestCases; i++) {
            knownWords = new LettersStateMachine();
//            knownWords=new HashSet<>();
            final int wordLength = in.nextInt();
            final int a = in.nextInt();
            final int b = in.nextInt();
            in.nextLine();
            final String expectedString = in.nextLine();
            System.out.println(calculateMinimumPrice(a, b, expectedString));
        }
    }

    private static int calculateMinimumPrice(final int insertCharacterPrice, final int copyStrPrice,
                                             final String expectedString) {
        int minimumPrice = 0;
        int stringStartIndex = 0;
        int stringEndIndex = 1;

        while (stringEndIndex < expectedString.length()) {
            String strToInsert = expectedString.substring(stringStartIndex, stringEndIndex);
            boolean foundToCopy = false;
            LettersStateMachine lettersStateMachine = knownWords;
            int i = stringStartIndex;
            while (true) {
                if (i >= expectedString.length()) {
                    strToInsert = expectedString.substring(stringStartIndex, i);
                    break;
                }
                lettersStateMachine = lettersStateMachine.getNextChild(expectedString.charAt(i));
                if (lettersStateMachine != null) {
                    foundToCopy = true;
                    i++;
                    continue;
                } else {
                    if (foundToCopy) {
                        strToInsert = expectedString.substring(stringStartIndex, i);
                    }
                    break;
                }
            }
            final int priceToInsert = strToInsert.length() * insertCharacterPrice;
            if (foundToCopy && copyStrPrice < priceToInsert) {
//                System.out.println("copy(): " + strToInsert);
                minimumPrice += copyStrPrice;
            } else {
//                System.out.println("append:  " + strToInsert);
                minimumPrice += insertCharacterPrice;

            }
            if (stringStartIndex + strToInsert.length() >= expectedString.length()) {
                break;
            }
            addWordToLettersStateMachine(stringStartIndex + 1, expectedString);
            stringStartIndex += strToInsert.length();
            stringEndIndex = stringStartIndex + 1;
        }
        return minimumPrice;
    }

    private static void addWordToLettersStateMachine(final int lettersAddedAlready, final String expectedString) {
        for (int addingIndex = 0; addingIndex < lettersAddedAlready; addingIndex++) {
            knownWords.add(expectedString.substring(lettersAddedAlready - addingIndex - 1, lettersAddedAlready));
        }
    }

    static class LettersStateMachine {

        private char letterValue;
        private Set<LettersStateMachine> children = new HashSet<>();

        LettersStateMachine() {
        }

        LettersStateMachine(final char letterValue) {
            this.letterValue = letterValue;
        }

        LettersStateMachine getNextChild(final char character) {
            for (LettersStateMachine child : children) {
                if (child.letterValue == character) {
                    return child;
                }
            }
            return null;
        }

        boolean contains(final String valueToGet) {
            if (valueToGet == null || valueToGet.isEmpty()) {
                return false;
            }
            for (LettersStateMachine child : children) {
                if (child.letterValue == valueToGet.charAt(0)) {
                    if (valueToGet.length() > 1) {
                        return child.contains(valueToGet.substring(1));
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }

        void add(final String strToInsert) {
            LettersStateMachine exitingChild = null;
            for (LettersStateMachine child : children) {
                if (child.letterValue == strToInsert.charAt(0)) {
                    exitingChild = child;
                }
            }
            if (exitingChild == null) {
                exitingChild = new LettersStateMachine(strToInsert.charAt(0));
                children.add(exitingChild);
            }
            if (strToInsert.length() > 1) {
                exitingChild.add(strToInsert.substring(1));
            }
        }

        @Override
        public String toString() {
            return letterValue + " -> " + children.toString();
        }
    }
}