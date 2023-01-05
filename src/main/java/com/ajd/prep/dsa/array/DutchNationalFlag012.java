package com.ajd.prep.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class DutchNationalFlag012 {
    public void reorder(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 0);
        countMap.put(1, 0);
        countMap.put(2, 0);

        for(int x : nums) {
            int tmp = countMap.get(x);
            countMap.put(x, tmp+1);
        }

        int idx = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < countMap.get(i); j++) {
                nums[idx++] = i;
            }
        }
    }

    public void reorder1(int[] nums) {

        int low = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 1) {
                int tmp = nums[low];
                nums[low] = nums[i];
                nums[i] = tmp;
                low++;
            }
        }

        int high = nums.length-1;
        for(int i = nums.length-1; i > -1; i--) {
            if(nums[i] > 1) {
                int tmp = nums[high];
                nums[high] = nums[i];
                nums[i] = tmp;
                high--;
            }
        }
    }

    public void reorder2(int[] nums) {

        // 2,0,1
        // unprocessed = 0, zero = 0, two = 2

        // iteration 1:
        //   unprocessed = 0 [2], zero = 0 [2], two = 2 [1]
        //   2,0,1
        //      loop: 0 < 2
        //      1, 0, 2
        //      two = 1


        // iteration 2:
        //   unprocessed = 0 [1], zero = 0 [1], two = 1 [0]
        //   1, 0, 2
        //      loop: 0 < 2
        //      1, 0, 2


        if(nums == null || nums.length < 2) {
            return;
        }

        int unprocessed = 0, zero = 0, two = nums.length-1;

        while(unprocessed <= two && zero < nums.length) {
            if(nums[unprocessed] == 1) {
                unprocessed++;
            } else if(nums[zero] == 0) {
                zero++;
            } else if(nums[two] == 2) {
                two--;
            } else {
                if(nums[unprocessed] == 0 && unprocessed > zero) {
                    int tmp = nums[zero];
                    nums[zero] = nums[unprocessed];
                    nums[unprocessed] = tmp;
                    zero++;
                } else if (nums[unprocessed] == 2) {
                    int tmp = nums[two];
                    nums[two] = nums[unprocessed];
                    nums[unprocessed] = tmp;
                    two--;
                } else {
                    unprocessed++;
                }
            }
        }
    }
}
