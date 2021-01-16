package com.example.snippets.demo.others;

public class CountValleys {

    public static void main(String[] args) {
        String path = "UDDDUDUUDU";
        System.out.println(countingValleys(path.length(), path));

    }

    static int countingValleys(int n, String s) {

        long x = 0l;
        int cantValleys = 0;
        String[] path = s.split("");

        for (int i = 0; i < n; i++) {
            long valAct = x;
            if (path[i].equalsIgnoreCase("u")) {
                valAct++;
            } else if (path[i].equalsIgnoreCase("d")) {
                valAct--;
            }

            if(x < 0 && valAct == 0){
                cantValleys++;
            }
            x = valAct;

        }

        return cantValleys;
    }
}
