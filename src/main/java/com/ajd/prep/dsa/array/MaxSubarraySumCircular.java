package com.ajd.prep.dsa.array;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        for(int x : nums) {
            totalSum += x;
        }

        if(nums.length == 1) {
            return totalSum;
        }

        int min = Integer.MAX_VALUE, tmpMin = 0, max = Integer.MIN_VALUE, tmpMax = 0;
        for(int x : nums) {
            tmpMax = x + Math.max(tmpMax, 0);
            max = Math.max(max, tmpMax);

            tmpMin = x + Math.min(tmpMin, 0);
            min = Math.min(min, tmpMin);
        }

        if (min == totalSum) {
            return max;
        }

        return Math.max(max, totalSum-min);
    }
}
