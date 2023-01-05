package com.ajd.prep.dsa.array;

public class BuySellStock {
    public int maxProfit(int[] prices) {
        int res = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++) {
            for(int j = i+1; j < prices.length; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }

        return Math.max(0, res);
    }

    public int maxProfit1(int[] prices) {
        int res = Integer.MIN_VALUE;

        for(int i = 0, j = 1; j < prices.length; j++) {
            int profit = prices[j] - prices[i];
            if(profit <= 0) {
                i = j;
            } else {
                res = Math.max(res, profit);
            }
        }

        return Math.max(0, res);
    }

    public int maxProfit2(int[] prices) {
        int res = Integer.MIN_VALUE;

        int minSoFor = prices[0];
        for(int i = 0; i < prices.length; i++) {
            res = Math.max(res, prices[i]-minSoFor);
            minSoFor = Math.min(minSoFor, prices[i]);
        }

        return res;
    }
}
