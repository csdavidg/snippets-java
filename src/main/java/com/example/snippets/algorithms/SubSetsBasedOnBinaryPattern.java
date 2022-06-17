package com.example.snippets.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubSetsBasedOnBinaryPattern {

    public void getSubSets(int[] numbers){
        System.out.println(Arrays.toString(numbers));
        int n = numbers.length;
        int maxBits = (int) Math.pow(2, n);
        int[] bits = IntStream.range(0, n)
                .map(num -> (int) Math.pow(2, num))
                .toArray();
        System.out.println(Arrays.toString(bits));

        for (int i = 0; i < maxBits; i++) {
            List<Integer> result = new ArrayList<>();
            int index = 0;
            while(index < bits.length){
                if((i & bits[index]) > 0){
                    result.add(numbers[index]);
                }
                index++;
            }
            System.out.println("i Value: " + i + " produce " + result);
        }

    }

    public List<Integer> recursiveSubsSet(List<Integer> numbers){
        if(numbers.size() == 0){
            return new ArrayList<>();
        }
        List<Integer> newList = recursiveSubsSet(numbers.subList(1, numbers.size()));
        List<Integer> result = new ArrayList<>();
        if(newList.isEmpty()){
            result = new ArrayList<>();
            result.add(numbers.get(0));
            System.out.println(result);
        }
        for(int num: newList){
            result = new ArrayList<>();
            result.add(numbers.get(0));
            result.add(num);
            result.add(num);
            System.out.println(result);
        }
        return result;
    }

}
