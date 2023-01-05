package com.ajd.prep.dsa.array;

import com.ajd.prep.dsa.array.DutchNationalFlag012;
import com.ajd.prep.dsa.array.MaxSubarraySumCircular;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@RunWith(Parameterized.class)
public class DutchNationalFlag012Test {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                {new int[]{2,0,2,1,1,0}, new int[]{0,0,1,1,2,2}},
                {new int[]{2,0,1}, new int[]{0,1,2}},
                {new int[]{0}, new int[]{0}},
                {new int[]{0, 0}, new int[]{0, 0}},
        });
    }

    // 5 -1 5 5 -1 5

    private DutchNationalFlag012 dutchNationalFlag012 = new DutchNationalFlag012();
    private int[] nums;
    private int[] res;

    public DutchNationalFlag012Test(int[] nums, int[] res) {
        this.nums = nums;
        this.res = res;
    }

    @Test
    public void reorderEvenFirstTest() {
        dutchNationalFlag012.reorder2(this.nums);
        assertArrayEquals(res, nums);
    }
}
