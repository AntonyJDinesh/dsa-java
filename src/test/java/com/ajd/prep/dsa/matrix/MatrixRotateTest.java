package com.ajd.prep.dsa.matrix;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@RunWith(Parameterized.class)
public class MatrixRotateTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                {
                    new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                    },
                    new int[][]{
                        {7, 4, 1},
                        {8, 5, 2},
                        {9, 6, 3}
                    },
                },
                {
                    new int[][] {
                        {5,1,9,11},
                        {2,4,8,10},
                        {13,3,6,7},
                        {15,14,12,16}
                    },
                    new int[][] {
                        {15,13,2,5},
                        {14,3,4,1},
                        {12,6,8,9},
                        {16,7,10,11}
                    }
                },
                {
                    new int[][] {
                            {1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9, 10, 11, 12},
                            {13, 14, 15, 16}
                    },
                    new int[][] {
                            {13,9,5,1},
                            {14,10,6,2},
                            {15,11,7,3},
                            {16,12,8,4}
                    }
                }
        });
    }

    private MatrixRotate matrixRotate = new MatrixRotate();
    private int[][] inp, res;

    public MatrixRotateTest(int[][] inp, int[][] res) {
        this.inp = inp;
        this.res = res;
    }

    @Test
    public void spiralOrderTest() {
        matrixRotate.rotate(this.inp);
        log.info("{}", Arrays.deepToString(this.inp));
        assertArrayEquals(res, inp);
    }
}
