package com.example.snippets.demo.others;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntegersTests {


    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 11, 4, 15, 6, 17, 8, 9, 10);

        Integer result = nums.stream().reduce(0, Integer::sum);
        System.out.println(result);

        List<Integer> collect = nums.stream().sorted().collect(Collectors.toList());


        result = nums.stream().reduce(0, Integer::max);
        System.out.println(result);

    }

}
