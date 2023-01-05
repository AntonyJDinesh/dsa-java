package com.ajd.prep.dsa.array;

public class AdvanceThroughArray {

    private int[] ht;
    // [3, 3, 2, 0, 2, 1, 0]
    public int findMinMovesDP1(int[] inp) {
        ht = new int[inp.length];
        for(int i = 0; i < inp.length; i++)
            ht[i] =  10001;

        int res = findRec(inp, 0);
        return res == 10001 ? -1 : res;
    }

    private int findRec(int[] inp, int pos) {
        if(pos >= inp.length-1) {
            return 0;
        }

        if(ht[pos] != 10001)
            return ht[pos];

        for(int move = 1; move <= inp[pos]; move++) {
            ht[pos] = Math.min(ht[pos], findRec(inp, pos+move) + 1);
        }

        return ht[pos];
    }

    public int findMinMovesDP2(int[] nums) {
        int n = nums.length-1;
        int jumps = 0, maxSoFor = 0, lastJumpedPos = 0;

        int i = 0;
        while(lastJumpedPos < n && i < n) {
            maxSoFor = Math.max(maxSoFor, i + nums[i]);

            if(i == lastJumpedPos && maxSoFor > 0) {
                jumps++;
                lastJumpedPos = maxSoFor;
            }

            i++;
        }

        return lastJumpedPos >= n ? jumps : -1;
    }
}
