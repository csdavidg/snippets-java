package com.example.snippets.algorithms;

public class BinaryGap {


    public int calculateBinaryGap(int number) {

        String binary = Integer.toBinaryString(number);
        char[] arrayChar = binary.toCharArray();
        int maxNumber = 0;
        int result = 0;
        for(char val : arrayChar){
            if (val == '1'){
                maxNumber = Integer.max(result, maxNumber);
                result = 0;
            } else {
                result++;
            }
        }
        return maxNumber;

    }
}
