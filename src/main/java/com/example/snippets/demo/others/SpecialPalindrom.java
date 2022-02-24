package com.example.snippets.demo.others;

public class SpecialPalindrom {

    public static void main(String[] args) {
        String word = "abcsa";
        System.out.println(isSpecialPalindrome(word));
    }

    public static boolean isPalindrome(String s){
        StringBuilder reverseString = new StringBuilder(s);
        reverseString.reverse();

        return reverseString.toString().equals(s);
    }

    public static boolean isSpecialPalindrome(String s){

        if(isPalindrome(s)){
            return true;
        }

        char[] chars = s.toCharArray();

        for(int i = 0; i< chars.length; i++ ){
            String section = s.substring(0, i) + s.substring(i+1);
            if(isPalindrome(section)){
                return true;
            }
        }
        return false;
    }

}