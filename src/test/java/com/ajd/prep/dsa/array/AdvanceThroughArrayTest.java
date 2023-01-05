package com.ajd.prep.dsa.array;

import com.ajd.prep.dsa.array.AdvanceThroughArray;
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
public class AdvanceThroughArrayTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                {new int[]{3, 3, 2, 0, 2, 1, 0}, 3},
                {new int[]{3, 2, 0, 0, 2, 1, 0}, -1},
                {new int[]{2,3,1,1,4}, 2},
                {new int[]{2,3,0,1,4}, 2},
                {new int[]{0}, 0},
        });
    }

    // 5 -1 5 5 -1 5

    private AdvanceThroughArray advanceThroughArray = new AdvanceThroughArray();
    private int[] inp;
    private int res;

    public AdvanceThroughArrayTest(int[] inp, int res) {
        this.inp = inp;
        this.res = res;
    }

    @Test
    public void reorderEvenFirstTest() {
        // int got = advanceThroughArray.findMinMovesDP1(this.inp);
        int got = advanceThroughArray.findMinMovesDP2(this.inp);
        assertEquals(res, got);
    }
}
