package com.ajd.prep.dsa.array;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@Slf4j
@RunWith(Parameterized.class)
public class NextBigPermutationTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                {new int[]{4,3,2,1}, new int[]{1, 2, 3, 4}},
                {new int[]{4,3,2,0,1}, new int[]{4,3,2,1,0}},
                {new int[]{2, 0, 1}, new int[]{2, 1, 0}},
                {new int[]{1, 0, 3, 2}, new int[]{1, 2, 0, 3}},
                {new int[]{0,1,2}, new int[]{0, 2, 1}},
                {new int[]{0, 2, 1}, new int[]{1,0,2}},
                {new int[]{1, 2, 3}, new int[]{1, 3, 2}},
                {new int[]{2, 3, 1}, new int[]{3, 1, 2}},
                {new int[]{1, 1}, new int[]{1, 1}},
                {new int[]{5,4,7,5,3,2}, new int[]{5,5,2,3,4,7}},

        });
    }

    private NextBigPermutation nextBigPermutation = new NextBigPermutation();
    private int[] inp, res;

    public NextBigPermutationTest(int[] inp, int[] res) {
        this.inp = inp;
        this.res = res;
    }

    @Test
    public void nextBigPermutationTest() {
        nextBigPermutation.getNext(this.inp);
        log.info("got: {}", this.inp);
        assertArrayEquals(res, this.inp);
    }
}
