package com.example.snippets.algorithms;

public class TennisTournament {

    public int solution(int P, int C) {

        if((P/2) > C || (P/2) == C){
            return C;
        }
        return P/2;
    }

}
