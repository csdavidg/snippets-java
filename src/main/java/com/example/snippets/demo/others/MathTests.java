package com.example.snippets.demo.others;

public class MathTests {

    public static void main(String[] args) {

        int x = 4 / 2 * 3 + (4 + 6 * 2) + 18 / 9 - 8;
        System.out.println("X Result " + x);


        double a = 11.5, b = 3.33;

        long c = Math.round(a / b);
        System.out.println("Long value " + c);

        double d = Math.round(a / b);
        System.out.println("double value " + d);

        double d2 = Math.round((double) a / b);
        System.out.println("double cast " + d2);


        double d3 = Math.round(a / b * 1000) / 1000.0;
        System.out.println("Multiplied by 100 " + d3);

        double d4 = Math.round(1000 * a / b) / 1000.0;
        System.out.println("Multiplied by 1000 Inverse " + d4);

        double explanation = 1000 * a / b;
        System.out.println(explanation);
        System.out.println(explanation / 1000);


        int result = 8 * 8 / 2 + 2 - 3 * 2;
        System.out.println("Result operations" + result);

        double resultOtherOperation = 11.5 * 1000 / 3.33;
        System.out.println(resultOtherOperation);

    }

}
