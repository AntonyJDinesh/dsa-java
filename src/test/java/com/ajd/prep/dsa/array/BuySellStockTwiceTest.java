package com.ajd.prep.dsa.array;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@RunWith(Parameterized.class)
public class BuySellStockTwiceTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                {new int[]{3,3,5,0,0,3,1,4}, 6},
                {new int[]{1,2,3,4,5}, 4},
                {new int[]{2,4,1}, 2},


        });
    }

    private BuySellStockTwice buySellStockTwice = new BuySellStockTwice();
    private int[] inp;
    private int res;

    public BuySellStockTwiceTest(int[] inp, int res) {
        this.inp = inp;
        this.res = res;
    }

    @Test
    public void reorderEvenFirstTest() {
        // int got = advanceThroughArray.findMinMovesDP1(this.inp);
        int got = buySellStockTwice.maxProfit2(this.inp);
        assertEquals(res, got);
    }
}
