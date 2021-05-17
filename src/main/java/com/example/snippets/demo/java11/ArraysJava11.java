package com.example.snippets.demo.java11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysJava11 {

    public static void main(String... args) {


        List<String> list = new ArrayList<>();
        list.add("hawk");
        list.add("robin");
        Object[] objectArray = list.toArray();
        String[] stringArray = list.toArray(new String[1]);
        list.clear();
        System.out.println(objectArray.length);     // 2
        System.out.println(stringArray.length);

        Character[] wolf = {'W', 'e', 'b', 'b', 'y'};

        List<Character> characters = Arrays.asList(wolf);

        String[] strings = {"hola", "Mundo"};
        List<String> stringList = Arrays.asList(stringArray);

        Integer[] intPrimitiveArr = {1,2,3,4,5};
        List<Integer> integersList = Arrays.asList(intPrimitiveArr);


    }

}
