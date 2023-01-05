package com.ajd.prep.dsa.array;

import java.util.PriorityQueue;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a-b);

        for(int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++) {
            if(pq.peek() < nums[i]) {
                pq.remove();
                pq.add(nums[i]);
            }
        }

        return pq.remove();
    }

    public int findKthLargestQuickSelect(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if(start == end) {
            return nums[start];
        }

        int pIndex = start, left = start, right = end;
        int pivot = nums[left];
        while(left < right) {
            if(nums[left] >= pivot) {
                left++;
            } else if(nums[right] <= pivot) {
                right--;
            } else {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }

        int tmp = nums[pIndex];
        nums[pIndex] = nums[right];
        nums[right] = tmp;

        if(right == k-1) {
            return pivot;
        } else if(right > k-1) {
            return quickSelect(nums,start, right-1, k-1);
        } else {
            return quickSelect(nums,right+1, end, k-1);
        }
    }
}
