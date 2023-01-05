package com.ajd.prep.dsa.array;

import com.ajd.prep.dsa.array.ReorderEvenFirst;
import com.ajd.prep.dsa.linkedlist.CommonInTwoSortedList;
import com.ajd.prep.dsa.linkedlist.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@RunWith(Parameterized.class)
public class ReorderEvenFirstTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                {new int[]{1,2,3,4,5,6}, new int[]{2,4,6,1,3,5}},
        });
    }


    private ReorderEvenFirst reorderEvenFirst = new ReorderEvenFirst();
    private int[] nums, res;

    public ReorderEvenFirstTest(int[] nums, int[] res) {
        this.nums = nums;
        this.res = res;
    }

    @Test
    public void reorderEvenFirstTest() {
        int[] got = reorderEvenFirst.reorderEvenFirst(this.nums);
        assertEquals(res, got);
    }

}
