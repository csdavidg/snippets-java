package com.example.snippets;

public class SearchValueInArray {

  /*{10, 20, 30, 40},
    {15, 25, 35, 45},
    {27, 29, 37, 48},
    {32, 33, 39, 50}}*/

  /*{00, 01, 02, 03},
    {10, 11, 12, 13},
    {20, 21, 22, 23},
    {30, 31, 32, 33}}*/

    public int[][] lookForIndex(int[][] matrix, int numberx) {
        int r = 0;
        int c = matrix[0].length-1;

        while(r < matrix.length && c >= 0){
            if(numberx == matrix[r][c]){
                return new int[][]{{r, c}};
            }else if(numberx < matrix[r][c]){
                c--;
            } else {
                r++;
            }
        }

        return new int[][]{{-1,-1}};
    }

    public int[][] lookForIndexError(int[][] matrix, int numberx){
        int r = matrix.length;
        int c = matrix[0].length;

        int cIndex = 0;
        int rIndex = 0;
        for ( ; rIndex < r; rIndex++) {
            if(numberx == matrix[rIndex][cIndex]){
                return new int[][]{{rIndex, cIndex}};
            }else if(numberx > matrix[rIndex][cIndex]){
                cIndex++;
            } else {
                break;
            }
        }
        //cIndex = 2
        //rIndex = 2
        if(cIndex == c){
            return new int[][]{{-1, -1}};
        }


        for (int i = rIndex-1; i >= 0; i--) {
            if(matrix[i][cIndex] == numberx){
                return new int[][]{{i, cIndex}};
            }
        }
        cIndex--;
        for (int i = r-1; i >=rIndex ; i--) {
            if(matrix[i][cIndex] == numberx){
                return new int[][]{{i, cIndex}};
            }
        }
        return null;
    }

}
