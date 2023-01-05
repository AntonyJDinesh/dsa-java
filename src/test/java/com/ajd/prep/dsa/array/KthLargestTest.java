package com.ajd.prep.dsa.array;

import com.ajd.prep.dsa.array.KthLargest;
import com.ajd.prep.dsa.array.Multiply;
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
public class KthLargestTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                {new int[]{3,2,1,5,6,4}, 2, 5},
        });
    }

    private KthLargest kthLargest = new KthLargest();
    private int[] nums;
    private int k, res;

    public KthLargestTest(int[] nums, int k, int res) {
        this.nums = nums;
        this.k = k;
        this.res = res;
    }

    @Test
    public void reorderEvenFirstTest() {
        int got = kthLargest.findKthLargestQuickSelect(this.nums, k);
        log.info("nums: {}", nums);
        assertEquals(res, got);
    }
}
