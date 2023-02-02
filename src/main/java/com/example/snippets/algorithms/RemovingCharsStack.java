package com.example.snippets.algorithms;

import java.util.Stack;

public class RemovingCharsStack {

    class Letter {
        char c;
        int count;

        Letter(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    /*
    abbcaacabc
    acaacabc
    accabc
    aabc
    bc
     */
    public String solution(String word, int k) {
        char[] arrW = word.toCharArray();
        Stack<Letter> stack = new Stack<>();
        stack.push(new Letter(arrW[0], 1));
        for (int i = 1; i < arrW.length; i++) {
            if(stack.isEmpty()){
                stack.push(new Letter(arrW[i], 1));
                continue;
            }
            Letter current = stack.pop();
            if (arrW[i] == current.c) {
                stack.push(new Letter(current.c, ++current.count));
                if (current.count == k) {
                    stack.pop();
                }
            } else {
                stack.push(current);
                stack.push(new Letter(arrW[i], 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop().c).reverse();
        }

        return sb.toString();
    }

}
