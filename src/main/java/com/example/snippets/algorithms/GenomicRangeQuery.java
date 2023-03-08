package com.example.snippets.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GenomicRangeQuery {

    /**
     * C A G C C  T  A
     *
     * 0 1 2 3 4  5  6
     * 2 1 3 2 2  4  1
     * 2 3 6 8 10 14 15
     *
     * P[0] = 2    Q[0] = 4
 *     P[1] = 5    Q[1] = 5
 *     P[2] = 0    Q[2] = 6
     *
     * A  C  G  T
 *     0  1  1  1  (at index 0)
 *     1  1  1  2  (at index 1)
 *     1  2  1  2  (at index 2)
 *     1  2  2  2  (at index 3)
 *     1  2  2  3  (at index 4)
 *     1  2  3  3  (at index 5)
 *     2  2  3  3  (at index 6)
     *
     */

    class Range {
        int min;
        int max;

        public Range(int min, int max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Range)) return false;
            Range range = (Range) o;
            return min == range.min && max == range.max;
        }

        @Override
        public int hashCode() {
            return Objects.hash(min, max);
        }
    }

    public int[] solution(String S, int[] P, int[] Q) {
        int N = S.length();
        int M = P.length;
        int[][] prefixSum = new int[N+1][4];

        // Fill in the prefix sum array
        for (int i = 0; i < N; i++) {
            System.arraycopy(prefixSum[i], 0, prefixSum[i+1], 0, 4);

            if (S.charAt(i) == 'A') {
                prefixSum[i+1][0]++;
            } else if (S.charAt(i) == 'C') {
                prefixSum[i+1][1]++;
            } else if (S.charAt(i) == 'G') {
                prefixSum[i+1][2]++;
            } else { // S.charAt(i) == 'T'
                prefixSum[i+1][3]++;
            }
        }

        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            int left = P[i];
            int right = Q[i] + 1;

            if (prefixSum[right][0] - prefixSum[left][0] > 0) {
                result[i] = 1;
            } else if (prefixSum[right][1] - prefixSum[left][1] > 0) {
                result[i] = 2;
            } else if (prefixSum[right][2] - prefixSum[left][2] > 0) {
                result[i] = 3;
            } else { // prefixSum[right][3] - prefixSum[left][3] > 0
                result[i] = 4;
            }
        }

        return result;
    }

}
