package com.example.snippets.algorithms;

public class Factorial {


    public int calculateFactorial(int number) {
        if (number <= 1) {
            return 1;
        }
        int total = number;
        while (--number > 0) {
            total *= number;
        }

        return total;
    }

    public int calculateFactorialRecursive(int number) {
        if (number == 0) {
            return 1;
        }
        return number * calculateFactorial(number - 1);
    }
}
