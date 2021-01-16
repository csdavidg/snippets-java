package com.example.snippets.demo.others;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int num = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Integer[][] matNum = new Integer[num][num];

        for (int i = 0; i < num; i++) {
            String[] nk = scanner.nextLine().split(" ");
            for (int j = 0; j < num; j++) {
                matNum[i][j] = Integer.parseInt(nk[j]);
            }
        }

        int que = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Map<Integer, List<Integer>> mapPos = new HashMap<>();

        for (int i = 0; i < que; i++) {
            String[] nk = scanner.nextLine().split(" ");
            mapPos.put(i, Stream.of(nk).map(Integer::parseInt).collect(Collectors.toList()));
        }

        Map<Integer, List<Integer>> mapCalc = new HashMap<>();

        mapPos.forEach((key, value) -> {
            int minRow = value.get(0) - 1;
            int maxRow = value.get(2);

            int minCol = value.get(1) - 1;
            int maxCol = value.get(3);

            List<Integer> calcList = new ArrayList<>();
            for (int i = minRow; i < maxRow; i++) {
                for (int j = minCol; j < maxCol; j++) {
                    calcList.add(matNum[i][j]);
                }
            }
            mapCalc.put(key, calcList);
        });

        mapCalc.forEach((key, value) -> {
            /*System.out.print(key + " -> ");
            value.forEach(System.out::print);
            System.out.print(" -> ");*/
            Collections.sort(value);
            int size = value.size();
            if (size % 2 > 0) {
                System.out.print(value.get(size / 2));
            } else {
                double result = Math.floor((value.get((size - 1) / 2) + value.get(size / 2)) / 2d);
                System.out.print((int) result);
            }
            System.out.println(" ");


        });

        scanner.close();
    }
}

