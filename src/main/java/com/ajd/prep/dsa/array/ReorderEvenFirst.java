package com.ajd.prep.dsa.array;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReorderEvenFirst {
    public int[] reorderEvenFirst(int[] nums) {
        int left = 0, right = nums.length-1;

        while(left < right) {
            while(left < right && nums[left]%2==0) {
                left++;
            }

            while(left < right && nums[right]%2==1) {
                right--;
            }

            if(left < right) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;

                left++;
                right--;
            }
        }

        return nums;
    }
}
