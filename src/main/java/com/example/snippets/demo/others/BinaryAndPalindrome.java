package com.example.snippets.demo.others;

import javax.naming.OperationNotSupportedException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class BinaryAndPalindrome {


    public String palindrome(String s) throws OperationNotSupportedException {

        if(Integer.parseInt(s) > 100_000){
            throw new OperationNotSupportedException("The number is grater than 100000");
        }

        Set<String> palindromes = new HashSet<>();
        if (isPalindrome(s)) {
            palindromes.add(s);
        }

        String[] arr = s.split("");

//        Set<String> setNumbers = Arrays.stream(arr).collect(Collectors.toSet());

        /*TreeMap<String, Long> numbersMap = Arrays.stream(arr)
                .collect(groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));*/

        Map<String, Long> numbersMap = Arrays.stream(arr)
                .collect(groupingBy(Function.identity(), Collectors.counting()));

        long count = numbersMap.values().stream()
                .filter(a -> a == 1)
                .count();

        if (count == s.length()) {
            return getMaxPalindrome(numbersMap.keySet());
        }

        /*Set<String> singleNumbers = numbersMap.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());*/

        palindromes.addAll(numbersMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1 && !entry.getKey().equals("0"))
                .map(e -> {
                    int size = (int) (e.getValue() / 2);

                    Set<String> pal = new HashSet<>();

                    numbersMap.entrySet().stream()
                            .filter(en -> !en.getKey().equals(e.getKey()))
                            .forEach(en -> {

                                String leadingValues = getStringWithLeadingValues(e.getKey(), size);
                                StringBuilder res = new StringBuilder(leadingValues);

                                if (en.getValue() == 1) {

                                    res.append(en.getKey()).append(leadingValues);
                                    pal.add(res.toString());
                                } else {

                                    res.append(getStringWithLeadingValues(en.getKey(), en.getValue().intValue()))
                                            .append(leadingValues);
                                    pal.add(res.toString());
                                }
                            });
                    return pal;
                }).flatMap(Collection::stream)
                .collect(Collectors.toSet()));

        return getMaxPalindrome(palindromes);

    }

    private String getStringWithLeadingValues(String number, int size) {
        String[] numRepeated = new String[size];
        Arrays.fill(numRepeated, number);
        return String.join("", numRepeated);
    }

    /*private Set<String> searchPalindrome(String s, String[] arr) {

        Set<String> palindromes = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            String subStr = s.substring(i);
            if (isPalindrome(subStr)) {
                palindromes.add(subStr);
            }
        }
        return palindromes;
    }*/

    public static String getMaxPalindrome(Collection<String> collection) {
        return collection.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .stream()
                .max(Integer::compareTo)
                .orElse(0).toString();
    }

    public static boolean isPalindrome(String s) {
        StringBuilder reverseString = new StringBuilder(s);
        reverseString.reverse();
        return reverseString.toString().equalsIgnoreCase(s);
    }

    public int binary(int a, int b) {

        String binary = Integer.toBinaryString(a*b);
        char[] arrayChar = binary.toCharArray();
        int result = 0;
        for(char val : arrayChar){
            if (val == '1'){
                result++;
            }
        }
        return result;
    }


}
