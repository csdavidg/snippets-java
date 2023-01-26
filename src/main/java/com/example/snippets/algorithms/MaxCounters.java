package com.example.snippets.algorithms;

import java.util.Arrays;

public class MaxCounters {

    public int[] solutionBadPerformance(int N, int[] A) {
        int[] counters = new int[N];
        int maxVal = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 1 && A[i] <= N) {
                counters[A[i] - 1] += 1;
                if (counters[A[i] - 1] > maxVal) {
                    maxVal = counters[A[i] - 1];
                }
            } else if (A[i] == (N + 1)) {
                Arrays.fill(counters, maxVal);
            }
        }

        return counters;
    }

    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int maxValue = 0;
        int[] maxValues = new int[A.length + 1];
        int maxValueCurrentPos = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 1 && A[i] <= N) {

                if (maxValueCurrentPos > 0 && counters[A[i] - 1] < maxValues[maxValueCurrentPos]) {
                    counters[A[i] - 1] = maxValues[maxValueCurrentPos] + 1;
                } else {
                    counters[A[i] - 1] += 1;
                }
                if (counters[A[i] - 1] > maxValue) {
                    maxValue = counters[A[i] - 1];
                }

            } else if (A[i] == (N + 1)) {
                maxValues[++maxValueCurrentPos] = maxValue;
            }
        }

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < maxValues[maxValueCurrentPos]) {
                counters[i] = maxValues[maxValueCurrentPos];
            }
        }

        return counters;
    }
}
