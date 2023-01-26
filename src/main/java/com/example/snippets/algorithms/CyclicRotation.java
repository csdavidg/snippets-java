package com.example.snippets.algorithms;

public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        if(A.length == 0){
            return A;
        }
        int from = (A.length - K);
        while(from < 0){
            from = A.length + from;
        }
        if(from == 0) {
            return A;
        }
        int to = A.length;
        int[] result = new int[A.length];
        int resultIndex = 0;
        for (int i = from; i <= to; i++) {
            if (i == A.length) {
                i = 0;
                to = from-1;
            }
            result[resultIndex++] = A[i];
        }
        return result;
    }
}
