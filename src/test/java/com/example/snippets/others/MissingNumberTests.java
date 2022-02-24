package com.example.snippets.others;

import com.example.snippets.demo.others.MissingNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MissingNumberTests {

    private MissingNumber missingNumber = new MissingNumber();


    @Test
    public void testMethod1(){
        int[] A = {-1, -3};
        int result = missingNumber.solution(A);
        System.out.println(result);
        Assertions.assertEquals(result, 1);
    }

    @Test
    public void testMethod2(){

        int[] B = {1, 2, 3, 5};
        int result = missingNumber.solution(B);
        System.out.println(result);
        Assertions.assertEquals(result, 4);

    }

    @Test
    public void testMethod3(){

        int[] C = {-1, -2, -4, 0, 1, 2, 3, 5};
        int result = missingNumber.solution(C);
        System.out.println(result);
        Assertions.assertEquals(result, 4);

    }

    @Test
    public void testMethod4(){

        int[] D = {-1, -2, -4, 0, 2, 3, 5};
        int result = missingNumber.solution(D);
        System.out.println(result);
        Assertions.assertEquals(result, 1);
    }

    @Test
    public void testMethod5(){

        int[] C = {-1, -2, -4, 0, 1, 1, 2, 2, 3, 5};
        int result = missingNumber.solution(C);
        System.out.println(result);
        Assertions.assertEquals(result, 4);

    }


}
