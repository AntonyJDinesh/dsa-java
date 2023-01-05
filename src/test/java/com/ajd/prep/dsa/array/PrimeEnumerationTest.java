package com.ajd.prep.dsa.array;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@RunWith(Parameterized.class)
public class PrimeEnumerationTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {Arrays.asList(new Integer[]{2, 3, 5, 7, 11, 13, 17}), 18, 7},
                {Arrays.asList(new Integer[]{2, 3, 5, 7}), 10, 4},
                {Arrays.asList(new Integer[]{}), 0, 0},
                {Arrays.asList(new Integer[]{}), 1, 0},
        });
    }

    private PrimeEnumeration primeEnumeration = new PrimeEnumeration();
    private List<Integer> res;
    private int n, count;

    public PrimeEnumerationTest(List<Integer> res, int n, int count) {
        this.n = n;
        this.res = res;
        this.count = count;
    }

    @Test
    public void test() {
        // int got = advanceThroughArray.findMinMovesDP1(this.inp);
        List<Integer> got = primeEnumeration.findAllPrimesInRange(this.n);
        assertEquals(res, got);
    }

    @Test
    public void countPrimesTest() {
        int got = primeEnumeration.countPrimes(this.n);
        assertEquals(this.count, got);
    }
}
