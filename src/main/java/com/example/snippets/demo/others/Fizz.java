package com.example.snippets.demo.others;

import java.util.stream.IntStream;

public class Fizz {

    public static void main(String[] args) {
        int n = 15;

        IntStream.rangeClosed(1, 15).forEach(number -> {
            String message = "";
            if(number % 3 == 0){
                message += "Fizz";
            }

            if(number % 5 == 0){
                message += "Buzz";
            }

            if(message.isEmpty()){
                message = String.valueOf(number);
            }
            System.out.println(message);
        });

    }


}
