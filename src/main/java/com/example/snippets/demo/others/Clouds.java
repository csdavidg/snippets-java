package com.example.snippets.demo.others;

public class Clouds {

    public static void main(String[] args) {
//        int[] numbers = {0, 1, 0, 0, 0, 1, 0};
        int[] numbers = {0,0,1,0,0,1,0};
        System.out.println(jumpingOnClouds(numbers));
    }

    private static int jumpingOnClouds(int[] c) {

        /*List<Integer> thunderClouds = new ArrayList<>();
        for (int index = 0; index < c.length; index++) {
            if (c[index] == 1) {
                thunderClouds.add(index);
            }
        }*/

        int index = 0;
        int validJumps = 0;
        while (index < (c.length - 1)) {
            if (c[index + 2] == 0) {
                validJumps++;
                index +=2;
            } else {
                validJumps++;
                index++;
            }
        }
        return validJumps;
    }
}
