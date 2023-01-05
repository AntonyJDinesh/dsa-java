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
public class BuySellStockTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                {new int[]{7,1,5,3,6,4}, 5},
                {new int[]{7,6,4,3,1}, 0},

        });
    }

    private BuySellStock buySellStock = new BuySellStock();
    private int[] inp;
    private int res;

    public BuySellStockTest(int[] inp, int res) {
        this.inp = inp;
        this.res = res;
    }

    @Test
    public void reorderEvenFirstTest() {
        // int got = advanceThroughArray.findMinMovesDP1(this.inp);
        int got = buySellStock.maxProfit2(this.inp);
        assertEquals(res, got);
    }
}
