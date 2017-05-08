package com.artigile.day12;

import java.util.Arrays;

/**
 * Created by ibahdanau on 5/8/17.
 */
class Student extends Person {
    private int[] testScores;

    /*
    *   Class Constructor
    *
    *   @param firstName - A string denoting the Person's first name.
    *   @param lastName - A string denoting the Person's last name.
    *   @param id - An integer denoting the Person's ID number.
    *   @param scores - An array of integers denoting the Person's test scores.
    */
    public Student(final String firstName, final String lastName, final int id, final int[] testScores) {
        super(firstName, lastName, id);
        this.testScores = testScores;
    }

    /*
   *   Method Name: calculate
   *   @return A character denoting the grade.
   */
    public char calculate() {
        final double averageScore = Arrays.stream(testScores).average().getAsDouble();
        if (averageScore >= 90 && averageScore <= 100) {
            return 'O';
        } else if (averageScore >= 80 && averageScore < 90) {
            return 'E';
        } else if (averageScore >= 70 && averageScore < 80) {
            return 'A';
        } else if (averageScore >= 55 && averageScore < 70) {
            return 'P';
        } else if (averageScore >= 40 && averageScore < 55) {
            return 'D';
        }
        return 'T';
    }
}