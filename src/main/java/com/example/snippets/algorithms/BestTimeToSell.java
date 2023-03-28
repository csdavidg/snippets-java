package com.example.snippets.algorithms;

public class BestTimeToSell {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int indexSell = 0;
        int minVal = prices[0];

        for(int i =1; i< prices.length; i++){
            if(prices[i] < minVal) {
                minVal = prices[i];
            } else {
                maxProfit = Integer.max(maxProfit, (prices[i] - minVal));
            }
        }

        return maxProfit;
    }
}
