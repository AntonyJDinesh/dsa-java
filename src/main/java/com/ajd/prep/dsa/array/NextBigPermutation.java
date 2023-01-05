package com.ajd.prep.dsa.array;

public class NextBigPermutation {
    public void getNext(int[] nums) {

        for(int i = nums.length-2; i >= 0; i--) {
            if(nums[i] <= nums[i+1]) {

                int nextSmallestIdx = -1;
                int nextSmallest = Integer.MAX_VALUE;

                for(int j = i+1; j < nums.length; j++) {
                    if(nums[j] > nums[i] && nums[j] < nextSmallest) {
                        nextSmallest = nums[j];
                        nextSmallestIdx = j;
                    }
                }

                if(nextSmallestIdx == -1) {
                    continue;
                }

                int tmp = nums[i];
                nums[i] = nums[nextSmallestIdx];
                nums[nextSmallestIdx] = tmp;

                sort: for(int k = i; k < nums.length-1; k++) {
                    boolean stop = true;
                    for (int j = nums.length - 2; j > k; j--) {
                        if (nums[j] > nums[j + 1]) {
                            tmp = nums[j];
                            nums[j] = nums[j + 1];
                            nums[j + 1] = tmp;
                            stop = false;
                        }
                    }

                    if(stop) {
                        break sort;
                    }
                }

                return;
            }
        }

        for(int i = 0, j = nums.length-1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
