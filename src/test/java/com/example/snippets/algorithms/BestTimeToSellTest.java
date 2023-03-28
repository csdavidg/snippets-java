package com.example.snippets.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimeToSellTest {

    @Test
    public void test() {
        BestTimeToSell bts = new BestTimeToSell();
        assertEquals(5, bts.maxProfit(new int[]{7,1,5,3,6,4}));
        assertEquals(0, bts.maxProfit(new int[]{7,6,4,3,1}));
        assertEquals(3, bts.maxProfit(new int[]{9,7,8,6,5,1,4}));

    }
}
