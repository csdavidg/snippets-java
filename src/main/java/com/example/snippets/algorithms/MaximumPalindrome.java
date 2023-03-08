package com.example.snippets.algorithms;

import org.springframework.util.comparator.Comparators;

import java.util.*;
import java.util.stream.Collectors;

public class MaximumPalindrome {

    private class ANumber {
        int k;
        int v;

        public ANumber(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    public String palindrome(String s) {

        char[] charsS = s.toCharArray();
        Map<Integer, Integer> amountChars = new LinkedHashMap<>();
        for (int num : charsS) {
            amountChars.merge(Character.getNumericValue(num), 1, Integer::sum);
        }

        Map<Integer, Integer> sortedMap = amountChars.entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .sorted(Map.Entry.<Integer, Integer>comparingByKey().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        Stack<Integer> stackOnes = new Stack<>();
        amountChars.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey)
                .ifPresent(stackOnes::add);

        Stack<Integer> integerStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, Integer> e : sortedMap.entrySet()) {
            int mid = e.getValue() / 2;
            int count = 0;
            while (count < mid) {
                sb.append(e.getKey());
                count++;
            }

            if (e.getValue() % 2 != 0) {
                if(stackOnes.isEmpty()){
                    stackOnes.add(e.getKey());
                }else {
                    stackOnes.add(Integer.max(e.getKey(), stackOnes.pop()));
                }
                count++;
            }

            while (count < e.getValue()) {
                integerStack.add(e.getKey());
                count++;
            }
        }

        if(!stackOnes.isEmpty()) {
            if (integerStack.size() == sb.length()) {
                sb.append(stackOnes.pop());
            } else {
                int max = Integer.max(stackOnes.pop(), integerStack.pop());
                sb.append(max);
            }
        }

        while (!integerStack.isEmpty()) {
            sb.append(integerStack.pop());
        }

        return sb.toString();
    }

    public String SolutionWorkingMax5Values(String s) {

        char[] charsS = s.toCharArray();
        Map<Integer, Integer> amountChars = new LinkedHashMap<>();
        for (int num : charsS) {
            amountChars.merge(Character.getNumericValue(num), 1, Integer::sum);
        }

        if (amountChars.size() == 1) {
            return s;
        }

        Map<Integer, Integer> sortedMap = amountChars.entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .sorted(Map.Entry.<Integer, Integer>comparingByKey().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        Integer maxOne = amountChars.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey)
                .orElse(-1);

        Stack<Integer> integerStack = new Stack<>();
        Integer missing = null;
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, Integer> e : sortedMap.entrySet()) {
            int mid = e.getValue() / 2;
            int count = 0;
            while (count < mid) {
                sb.append(e.getKey());
                count++;
            }

            if (e.getValue() == 3) {
                missing = e.getKey();
                count++;
            }

            while (count < e.getValue()) {
                integerStack.add(e.getKey());
                count++;
            }

            if (e.getValue() == 1 && sb.length() > 0) {
                break;
            }
        }

        if(maxOne > -1) {
            integerStack.add(maxOne);
        }

        if (missing != null) {
            if (integerStack.size() == sb.length()) {
                sb.append(missing);
            } else {
                int max = Integer.max(missing, integerStack.pop());
                sb.append(max);
            }
        }

        while (!integerStack.isEmpty()) {
            sb.append(integerStack.pop());
        }

        /*sortedMap.forEach((key, value) -> {

        });*/

        return sb.toString();

    }
}
