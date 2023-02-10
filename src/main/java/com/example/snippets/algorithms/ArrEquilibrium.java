package com.example.snippets.algorithms;

public class ArrEquilibrium {

    //(3) - (1,2,4,3) - 1
    //(3,1) - (2,4,3) - 2
    //(3,1,2) - (4,3) - 3
    //(3,1,2,4) - (3) - 4
    public int solution(int[] A) {
        String s = new String("HELLO");
        s.contains("H");
        int p = 1;
        int firstSum = 0;
        int secondSum = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i <(A.length-1); i++){
            firstSum += A[i];
            if(p == 1){
                for(int j = p; j < A.length; j++){
                    secondSum += A[j];
                }
            } else {
                secondSum -= A[i];
            }
            min = Integer.min(min, Math.abs(firstSum - secondSum));
            p++;
        }
        return min;
    }
}
