package com.example.snippets.demo.java11;

import java.util.Arrays;

public class VarFeatures {

    public static void main(String[] args) {


        char[] wolf = {'W', 'e', 'b', 'b', 'y'};

        System.out.println(Arrays.toString(wolf));

        checkReturnTypeForVoid('A');
        checkReturnTypeForVoid('a');


        for(int m=wolf.length-1; m>=0; --m)
            System.out.print(wolf[m]);

        for(int i=wolf.length; i>0; --i)
            System.out.print(wolf[i]);






        var number = (short) 120;
        number = (byte) 50;
//        number = 100000;
        System.out.println(number);

        byte byteNumber = 127;
        short shortNumber = 125;
        System.out.println(byteNumber);
        System.out.println(shortNumber);

        var nullObject = (Object) null;



        /*

            To use a var, you must initialize in the same statement when it's declared
            so the compiler can not infer the type
            var doesNotCompile;
            doesNotCompile = 10;

        */

        int lion = 5;
        int tiger = ++lion * 2 / lion--;
        System.out.println("Lion is " + lion);
        System.out.println("Tiger is " + tiger);


        float floatNumber = 10.0f;
        Float wrapperFloatNumber = 10.0F;
        Double wrapperDoubleNumber = 10d;

        short n1 = 10;
        short n2 = 3;
//        n2 *= n1;

        n2 = (n1 = 15);
        System.out.println("N2 VAL "+n2 + " N1 VAL "+n1);

        Integer intNum = Integer.valueOf("10");
        System.out.println(intNum instanceof Number);
        System.out.println(intNum instanceof Object);

        openZoo(2);
        openZoo(2.0);


    }

    public static void openZoo(Number num){
        if(num instanceof Integer){
            System.out.println(num + " O'Clock");
        }
        if(num instanceof Double){
            System.out.println(num + " O'Clock D");
        }

        String type = num.getClass().getSimpleName();

        switch (type){
            case "Double":
                System.out.println(num + " O'Clock D");
                break;
            case "Integer":
                System.out.println(num + " O'Clock");
                break;
            default:
                System.out.println("DEFAULT");
        }

    }

    public static void checkReturnTypeForVoid(char character){
        if(character == 'a'){
            System.out.println("IS A");
            return;
        }
        System.out.println("IS NOT A");
    }


}
