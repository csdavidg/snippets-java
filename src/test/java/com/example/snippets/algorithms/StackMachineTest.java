package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackMachineTest {

    private StackMachine target = new StackMachine();

    @Test
    public void test(){
        int result = 0;

        result = target.solution("DUP POP");
        assertEquals(-1, result);

        result = target.solution("10 2 -");
        assertEquals(-1, result);

        result = target.solution("eqiweuwqi qwe dqe");
        assertEquals(-1, result);

        result = target.solution("");
        assertEquals(-1, result);

        result = target.solution(" ");
        assertEquals(-1, result);

        result = target.solution("1048575 DUP +");
        assertEquals(-1, result);

        result = target.solution("6 POP");
        assertEquals(-1, result);

        result = target.solution("1048400 1048400 + -");
        assertEquals(-1, result);

        result = target.solution("13 DUP 4 POP 5 DUP + DUP + -");
        assertEquals(7, result);

        result = target.solution("5 6 + -");
        assertEquals(-1, result);

        result = target.solution("3 DUP 5 - -");
        assertEquals(-1, result);

        result = target.solution("4 5 6 - 7 +");
        assertEquals(8, result);
    }

}
