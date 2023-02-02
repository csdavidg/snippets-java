package com.example.snippets.algorithms;

import java.util.Stack;

public class VoraciousFishesStack {

    class Fish {
        int size, direction;

        Fish(int s, int d) {
            size = s;
            direction = d;
        }
    }

    public int solution(int[] A, int[] B) {
        Stack<Fish> survivorFishes = new Stack<>();
        survivorFishes.push(new Fish(A[0], B[0]));
        for (int i = 1; i < A.length; i++) {
            Fish before = survivorFishes.pop();

            if (before.direction == 1 && B[i] == 0) {
                if (before.size > A[i]) {
                    survivorFishes.push(before);
                } else {
                    while(!survivorFishes.isEmpty()){
                        before = survivorFishes.pop();
                        if(before.direction == 0){
                            survivorFishes.push(before);
                            survivorFishes.push(new Fish(A[i], B[i]));
                            break;
                        } else if(before.direction == 1 && before.size > A[i]){
                            survivorFishes.push(before);
                            break;
                        }else if(before.direction == 1 && before.size < A[i]) {
                            continue;
                        }
                    }
                    if(survivorFishes.isEmpty()){
                        survivorFishes.push(new Fish(A[i], B[i]));
                    }
                }
            } else {
                survivorFishes.push(before);
                survivorFishes.push(new Fish(A[i], B[i]));
            }
        }

        return survivorFishes.size();
    }
}
