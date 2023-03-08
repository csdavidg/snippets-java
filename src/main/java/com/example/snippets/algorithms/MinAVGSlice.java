package com.example.snippets.algorithms;


/*
A[0] = 4 - 4
A[1] = 2 - 6
A[2] = 2 - 8
A[3] = 5 - 13
A[4] = 1 - 14
A[5] = 5 - 19
A[6] = 8 - 27

*/


public class MinAVGSlice {

    public int solution(int[] A) {

        double[] subSum = new double[A.length];
        subSum[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            subSum[i] = subSum[i - 1] + A[i];
        }

        double minVal = 10000;
        int pos = 0;

        for (int p = 0; p < subSum.length - 1; p++) {
            double pVal = (p > 0) ? subSum[p-1] : 0;
            double avg1 = (subSum[p + 1] - pVal) / 2;
            double avg2 = avg1;
            if(p < subSum.length - 2) {
                avg2 = (subSum[p + 2] - pVal) / 3;
            }
            double minSlice = Math.min(avg1, avg2);

            if (minSlice < minVal) {
                minVal = minSlice;
                pos = p;
            }
        }
        return pos;
    }

    public int firstSolution(int[] A) {

        double[] subSum = new double[A.length];
        subSum[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            subSum[i] = subSum[i - 1] + A[i];
        }

        int p = 0;
        int q = Math.min((p + 3), A.length - 1);

        double minVal = 10000;
        int pos = A.length;

        while (p < q) {
            double avg = 0;
            if (p == 0) {
                avg = (subSum[q] - 0) / (q - p + 1);
            } else {
                avg = (subSum[q] - subSum[p - 1]) / (q - p + 1);
            }
            if (avg < minVal) {
                minVal = avg;
                pos = p;
            }
            q--;
            if (q == p) {
                p++;
                q = Math.min((p + 3), A.length - 1);
            }
        }

        return pos;
    }
}
