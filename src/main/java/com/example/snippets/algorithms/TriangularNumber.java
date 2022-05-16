package com.example.snippets.algorithms;

public class TriangularNumber {


    public int calculateTriangularNumber(int number) {

        int total = 0;
        while (number > 0) {
            total += number;
            number--;
        }
        return total;
    }

    public int calculateTriangularNumberRecursive(int number) {

        if (number == 1) {
            return 1;
        }
        return number + calculateTriangularNumberRecursive(number - 1);
    }


}
