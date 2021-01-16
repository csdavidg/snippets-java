package com.example.snippets.demo.others;

import java.util.stream.Stream;

public class InfinityString {


    public static final String LETTER = "a";

    public static void main(String[] args) {

        String infinity = "ojowrdcpavatfacuunxycyrmpbkvaxyrsgquwehhurnicgicmrpmgegftjszgvsgqavcrvdtsxlkxjpqtlnkjuyraknwxmnthfpt";
        //abachoabac
        System.out.println("REPEATED "+repeatedString(infinity, 685118368975L));
        System.out.println("BUILD    "+buildInfinityString(infinity, 685118368975L));
        System.out.println("EXPECTED " + 41107102139L);
    }


    static long buildInfinityString(String s, long n){
        String[] wordList = s.split("");
        if (wordList.length == 1 && s.equalsIgnoreCase(LETTER)) {
            return n;
        }

        long count = 0;
        long index = 0;
        while (index < n) {
            for (String letter : wordList) {
                if (letter.equalsIgnoreCase("a") && index < n) {
                    count++;
                }
                index++;
            }
        }

        return count;
    }



    static long repeatedString(String s, long n) {

        if(s == null || s.isEmpty()) {
            return 0;
        }else if(s.length() == 1){
            if (s.equalsIgnoreCase(LETTER)) {
                return n;
            }
            return 0;
        }else{
            Long duplicate = n / s.length();
            Long remaining = n % s.length();

            String[] letters = s.split("");
            long cantAs = Stream.of(letters).filter(letter -> letter.equalsIgnoreCase(LETTER)).count();

            long count = cantAs * duplicate;

            if(remaining > 0){
                String withoutRemain = s.substring(0, remaining.intValue());
                letters = withoutRemain.split("");
                long asInRemain = Stream.of(letters).filter(letter -> letter.equalsIgnoreCase(LETTER)).count();
                count += asInRemain;
            }

            return count;
        }
    }

}
