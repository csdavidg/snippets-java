package com.example.snippets.algorithms;

import java.util.LinkedList;
import java.util.Stack;

public class ParenthesisPairs {

    public int solution(String S) {
        if (S.isEmpty()) {
            return 1;
        }
        LinkedList<Character> stackCh = new LinkedList<>();
        char[] arr = S.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stackCh.addLast(arr[i]);
            } else if (arr[i] == ')' && !stackCh.isEmpty()) {
                Character open = stackCh.pollLast();
                if (open != '(') {
                    return 0;
                }
            } else {
                return 0;
            }
        }

        return stackCh.isEmpty() ? 1 : 0;
    }

    public int solutionUsingStack(String S) {
        if (S.isEmpty()) {
            return 1;
        }
        Stack<Character> stackCh = new Stack<>();
        char[] arr = S.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stackCh.push(arr[i]);
            } else if (arr[i] == ')' && !stackCh.isEmpty()) {
                Character open = stackCh.pop();
                if (open != '(') {
                    return 0;
                }
            } else {
                return 0;
            }
        }

        return stackCh.isEmpty() ? 1 : 0;
    }

}
