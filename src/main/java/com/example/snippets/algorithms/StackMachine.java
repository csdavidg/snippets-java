package com.example.snippets.algorithms;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackMachine {

    public int solution(String s) {

        String[] operations = s.split(" ");
        Stack<Integer> numbers = new Stack<>();
        int maxNumber = (int) (Math.pow(2, 20) - 1);
        try {
            for (String op : operations) {
                if (isANumber(op)) {
                    int val = Integer.parseInt(op);
                    numbers.push(addValidNumber(val, maxNumber));
                } else {

                    int first = 0;
                    int second = 0;

                    switch (op) {
                        case "POP":
                            numbers.pop();
                            break;
                        case "DUP":
                            int topMost = numbers.pop();
                            numbers.push(topMost);
                            numbers.push(topMost);
                            break;
                        case "+":
                            first = numbers.pop();
                            second = numbers.pop();
                            numbers.push(addValidNumber(first + second, maxNumber));
                            break;
                        case "-":
                            first = numbers.pop();
                            second = numbers.pop();
                            numbers.push(addValidNumber(first - second, maxNumber));
                            break;
                        default:
                            return -1;
                    }
                }
            }
            return numbers.pop();
        }catch (EmptyStackException | NumberFormatException e){
            return -1;
        }
    }

    private int addValidNumber(int val, int maxNumber) throws NumberFormatException{
        if(val >= 0 && val < maxNumber){
            return val;
        }
        throw new NumberFormatException();
    }

    public boolean isANumber(String op) {
        try {
            Integer.parseInt(op);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
