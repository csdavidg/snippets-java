package com.example.snippets.demo.others;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingNumber {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString('A'));
    }

        public int solution(int[] A) {
            Arrays.sort(A);
            Set<Integer> numbers = Arrays.stream(A)
                    .filter(x -> x > 0)
                    .boxed()
                    .collect(Collectors.toSet());
            int before = 0;
            for (int val : A) {
                if(val < 0){
                    continue;
                }
                int result = val - before;
                if(result == 0 || result == 1){
                    before = val;
                }else{
                    return ++before;
                }
            }
            return ++before;
        }


}
