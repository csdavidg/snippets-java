package com.example.snippets.demo.others;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Socks {

    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 10, 10, 30, 50, 10, 20, 10, 10};
        System.out.println(sockMerchant(arr.length, arr));
    }

    static int sockMerchant(int n, int[] ar) {
        List<Integer> ints = Arrays.stream(ar).boxed().collect(Collectors.toList());
        int total = 0;
        for (int number : ar) {
            long cant = ints.stream().filter(i-> i.equals(number)).count();
            total += Math.toIntExact(cant / 2);
            ints.removeIf(x -> x.equals(number));
        }
        return total;
    }

}
