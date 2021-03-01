package com.example.snippets.demo.others;

public class MathTests {

    public static void main(String[] args) {

        double a = 11.5, b = 3.33;

        long c = Math.round(a / b);
        System.out.println("Long value " + c);

        double d = Math.round(a / b);
        System.out.println("double value " + d);

        double d2 = Math.round((double) a / b);
        System.out.println("double cast " + d2);


        double d3 = Math.round(a / b * 1000) / 1000.0;
        System.out.println("Multiplied by 100 " + d3);

        double explanation = a / b * 1000;
        System.out.println(explanation);
        System.out.println(explanation / 1000);

    }

}
