package com.example.snippets.algorithms;

public class Tournament {

    public int getChampion(int[] teams){

        int n = teams.length -1;
        int[] winners = new int[n];

        int idx = 0;
        for (int i = 0; i < n; i += 2) {
            winners[idx] = Integer.max(teams[i], teams[i+1]);
            /*if(teams[i] < teams[i+1]){
                winners[idx] = teams[i+1];
            } else {
                winners[idx] = teams[i];
            }*/
            idx++;
        }

        for (int i = 0; i < n-1; i+=2) {
            winners[idx] = Integer.max(winners[i], winners[i+1]);
            /*if(winners[i] < winners[i+1]){
                winners[idx] = winners[i+1];
            } else {
                winners[idx] = winners[i];
            }*/
            idx++;
        }


        return winners[idx-1];
    }

}
