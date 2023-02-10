package com.example.snippets.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GenomicRangeQuery {

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
        // Implement your solution here

        int[] result = new int[P.length];
        Map<Range, Integer> subStrMap = new HashMap<>();
        int resPosition = 0;
        for(int i = 0; i < P.length; i++) {
            Range range = new Range(P[i], Q[i]);
            String sub = S.substring(P[i], Q[i] + 1);



            resPosition++;
        }

        return result;
    }

}
