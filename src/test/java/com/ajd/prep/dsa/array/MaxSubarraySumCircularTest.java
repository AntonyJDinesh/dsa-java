package com.ajd.prep.dsa.array;

import com.ajd.prep.dsa.array.MaxSubarraySumCircular;
import com.ajd.prep.dsa.array.ReorderEvenFirst;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@RunWith(Parameterized.class)
public class MaxSubarraySumCircularTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                {new int[]{5, -1, 5}, 10},
        });
    }

    // 5 -1 5 5 -1 5

    private MaxSubarraySumCircular maxSubarraySumCircular = new MaxSubarraySumCircular();
    private int[] nums;
    private int res;

    public MaxSubarraySumCircularTest(int[] nums, int res) {
        this.nums = nums;
        this.res = res;
    }

    @Test
    public void reorderEvenFirstTest() {
        int got = maxSubarraySumCircular.maxSubarraySumCircular(this.nums);
        assertEquals(res, got);
    }
}
