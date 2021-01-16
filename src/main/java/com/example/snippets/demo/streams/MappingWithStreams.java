package com.example.snippets.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MappingWithStreams {

    public static void main(String[] args) {
        /*List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        List<Integer> powList = new ArrayList<>();
        numbers.forEach(n -> powList.add((int) Math.pow(n, 2)));
        powList.forEach(System.out::println);

        numbers.stream().map(n -> Math.pow(n, 2)).forEach(System.out::println);*/

        List<Integer> arrNum1 = Arrays.asList(1, 2, 3);
        List<Integer> arrNum2 = Arrays.asList(3, 4);

        System.out.println("FIRST PROCESS");

        List<int[]> collect = arrNum1.stream()
                .flatMap(n ->
                        arrNum2.stream()
                                .map(n2 -> new int[]{n, n2}))
                .collect(Collectors.toList());

        collect.forEach(a -> {
            System.out.print("{");
            for (int i : a) {
                System.out.print(i);
            }
            System.out.print("}");
        });

        System.out.println("");
        System.out.println("SECOND PROCESS");

        arrNum1.stream()
                .flatMap(n ->
                        arrNum2.stream()
                                .map(n2 -> new int[]{n, n2}))
                .forEach(a -> {
                    System.out.print("{");

                    for (int i : a) {
                        System.out.print(i);
                    }
                    //System.out.print(a[0] + " , " + a[1]);
                    System.out.print("}");
                });

    }

}
