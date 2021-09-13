package com.example.snippets.demo.functional;

import java.util.function.DoubleUnaryOperator;

public class Currying {

    public static void main(String[] args) {

        //Convert Celsius to Fahrenheit
        double xCelsius = 10;
        double conversionFactorFahrenheit = 9.0/5;
        double baseLine = 32;
        System.out.println("Fahrenheit " +converter(xCelsius, conversionFactorFahrenheit, baseLine));

        //Convert USD to GBP
        double xUSD = 10;
        double conversionFactorGBP = 0.72;
        double baseLineGBP = 0;
        System.out.println("GBP " + converter(xUSD, conversionFactorGBP, baseLineGBP));


         //USING CURRYING

        DoubleUnaryOperator convertCtoF = curriedConverter(9.0/5, 32);
        DoubleUnaryOperator convertUSDtoGBP = curriedConverter(0.72, 0);
        DoubleUnaryOperator convertKmtoMi = curriedConverter(0.6214, 0);

        System.out.println("Currying way Fahrenheit " + convertCtoF.applyAsDouble(xCelsius));
        System.out.println("Currying way Fahrenheit " + convertUSDtoGBP.applyAsDouble(xUSD));

    }

    /**
     * The basic pattern of unit conversions
     * 1. Multiply by the conversion factor. (x*conversionFactor)
     * 2. Adjust the baseline if relevant.(result of multiplication) + baseLine
     */
    static double converter(double x, double conversionFactor, double baseLine) {
        return x * conversionFactor + baseLine;
    }

    static DoubleUnaryOperator curriedConverter(double f, double b){
        return (double x) -> x * f + b;
    }


}
