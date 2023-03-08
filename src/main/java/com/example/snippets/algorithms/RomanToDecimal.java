package com.example.snippets.algorithms;

import java.util.HashMap;
import java.util.Map;

public class RomanToDecimal {

    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int decimal = roman.get(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            int current = roman.get(s.charAt(i));
            int before = roman.get(s.charAt(i-1));

            if(before < current){
                decimal -= before;
                decimal += (current - before);
            } else {
                decimal += current;
            }
        }
        return decimal;
    }

    public int romanToIntFirst(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        char[] arrCh = s.toCharArray();

        int decimal = roman.get(arrCh[0]);
        for(int i = 1; i < s.length(); i++){
            int current = roman.get(arrCh[i]);
            int before = roman.get(arrCh[i-1]);

            if(before < current){
                decimal -= before;
                decimal += (current - before);
            } else {
                decimal += current;
            }
        }
        return decimal;
    }
}
