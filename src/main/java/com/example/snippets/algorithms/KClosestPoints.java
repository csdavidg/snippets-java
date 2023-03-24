package com.example.snippets.algorithms;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class KClosestPoints {

    public int[][] solution(int[][] points, int k) {

        Comparator<int[][]> comparePoints = (a, b) -> {
            double distance = Math.pow(a[0][0], 2) + Math.pow(a[0][1], 2);
            double distance2 = Math.pow(b[0][0], 2) + Math.pow(b[0][1], 2);
            if (distance2 == distance) {
                return 1;
            }
            return Double.compare(distance, distance2);
        };

        TreeSet<int[][]> result = new TreeSet<>(comparePoints);

        for (int i = 0; i < points.length; i++) {
            result.add(new int[][]{{points[i][0], points[i][1]}});
        }

        int[][] arr = new int[k][2];
        int count = 0;
        for (int i = 0; i < k; i++) {
            int[][] current = result.pollFirst();
            if (current != null) {
                arr[i][0] = current[0][0];
                arr[i][1] = current[0][1];
            }
            count++;
            if (count == k) {
                break;
            }
        }
        return arr;
    }
}
