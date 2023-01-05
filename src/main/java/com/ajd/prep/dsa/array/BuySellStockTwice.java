package com.ajd.prep.dsa.array;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BuySellStockTwice {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }

        int res = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length-2; i++) {
            int max1 = maxProfitInRange(prices, 0, i);
            int max2 = maxProfitInRange(prices, i+1, prices.length-1);
            log.info("i: {} :: (0, {}) = {} && ({}, {}) = {}", i, i, max1, i+1, prices.length-1, max2);
            if(max1 < 0 || max2 < 0) {
                continue;
            }

            res = Math.max(res, max1+max2);
        }

        res = Math.max(res, maxProfitInRange(prices, 0, prices.length-1));
        return res;
    }

    private int maxProfitInRange(int[] prices, int start, int end) {
        int res = Integer.MIN_VALUE;

        int minSoFor = prices[start];
        for(int i = start; i <= end; i++) {
            res = Math.max(res, prices[i]-minSoFor);
            minSoFor = Math.min(minSoFor, prices[i]);
        }

        return res;
    }

    public int maxProfit2(int[] prices) {

        int[] maxProfit = new int[prices.length];
        int minSoFar = prices[0], max = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            max = Math.max(max, prices[i] - minSoFar);
            minSoFar = Math.min(minSoFar, prices[i]);
            maxProfit[i] = max;
        }

        int[] maxProfitIfBuyOnThatDay = new int[prices.length];
        int maxSoFar = prices[prices.length-1];

        for(int i = prices.length-1; i > -1; i--) {
            int profit = maxSoFar - prices[i];
            maxProfitIfBuyOnThatDay[i] = Math.max(0, profit);
            maxSoFar = Math.max(maxSoFar, prices[i]);
        }

        int[] maxRes = new int[prices.length];
        int maxProfitI = 0;
        for(int i = 0; i < prices.length; i++) {
            maxRes[i] = maxProfitIfBuyOnThatDay[i] + maxProfitI;
            maxProfitI = maxProfit[i];
        }

        int res = Integer.MIN_VALUE;
        for(int price : maxRes) {
            res = Integer.max(res, price);
        }

        return res;
    }
}
