package com.ajd.prep.dsa.array;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            int j = i;
            while(j < n && nums[i] == nums[j]) {
                j++;
            }

            if(j-i == 1) {
                continue;
            }

            if(j >= n) {
                n = i+1;
                break;
            }

            for(int a = i+1, b = j; b < n; a++, b++) {
                nums[a] = nums[b];
            }

            n = n - (j - i) + 1;
        }

        return n;
    }

    public int removeDuplicates1(int[] nums) {
        int lastW = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[lastW-1] != nums[i]) {
                nums[lastW++] = nums[i];
            }
        }

        return lastW;
    }
}
