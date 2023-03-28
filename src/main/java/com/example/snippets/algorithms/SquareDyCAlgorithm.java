package com.example.snippets.algorithms;

public class SquareDyCAlgorithm {

    public int[] getMaxSize(int[] sides){
        int nextSize = 0;
        int minValue = 0;
        if(sides[0] < sides[1]){
            nextSize = sides[1] - sides[0];
            minValue = sides[0];
        } else if (sides[0] > sides[1]){
            nextSize = sides[0] - sides[1];
            minValue = sides[1];
        } else {
            return new int[]{sides[0], sides[1]};
        }
        return getMaxSize(new int[]{nextSize, minValue });
    }

}
