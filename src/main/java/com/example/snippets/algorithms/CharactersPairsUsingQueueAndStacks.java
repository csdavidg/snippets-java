package com.example.snippets.algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class CharactersPairsUsingQueueAndStacks {

    public int solution(String S) {
        if (S.isEmpty()) {
            return 0;
        }
        char[] chars = S.toCharArray();

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> charType = new HashMap<>();
        charType.put('{', 'o');
        charType.put('(', 'o');
        charType.put('[', 'o');
        charType.put('}', 'c');
        charType.put(')', 'c');
        charType.put(']', 'c');

        Map<Character, Character> charPairs = new HashMap<>();
        charPairs.put('{', '}');
        charPairs.put('(', ')');
        charPairs.put('[', ']');
        charPairs.put('}', '{');
        charPairs.put(')', '(');
        charPairs.put(']', '[');


        for (int i = 0; i < chars.length; i++) {
            Character type = charType.get(chars[i]);

            if (type == null) {
                return 0;
            }

            if (type == 'o') {
                stack.push(chars[i]);
            } else if (!stack.isEmpty() && type == 'c') {
                if (charPairs.get(stack.pop()) != chars[i]) {
                    return 0;
                }
            } else {
                return 0;
            }

        }

        return stack.isEmpty() ? 1 : 0;
    }

    public int solutionWithOtherStructures(String S) {
        char[] chars = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        Map<Character, Character> charPairs = new HashMap<>();
        charPairs.put('{', '}');
        charPairs.put('(', ')');
        charPairs.put('[', ']');

        charPairs.put('}', '{');
        charPairs.put(')', '(');
        charPairs.put(']', '[');

        for (int i = 0; i < chars.length; i++) {
            stack.add(chars[i]);
            queue.add(chars[i]);
        }

        while (!stack.isEmpty() && !queue.isEmpty()) {
            Character qVal = queue.poll();
            Character stVal = stack.pop();
            if (charPairs.get(stVal) != qVal) {
                return 0;
            }
        }

        return 1;
    }
}
