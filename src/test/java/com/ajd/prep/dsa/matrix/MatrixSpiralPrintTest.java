package com.ajd.prep.dsa.matrix;

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
public class MatrixSpiralPrintTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                {new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }, Arrays.asList(new Integer[]{1, 2, 3, 6, 9, 8, 7, 4, 5})},
                {new int[][]{
                        {1, 2, 3}
                }, Arrays.asList(new Integer[]{1, 2, 3})},
                {new int[][]{
                        {1, 2, 3},
                        {4, 5, 6}
                }, Arrays.asList(new Integer[]{1, 2, 3, 6, 5, 4})},
        });
    }

    private MatrixSpiralPrint matrixSpiralPrint = new MatrixSpiralPrint();
    private int[][] inp;
    private List<Integer> res;

    public MatrixSpiralPrintTest(int[][] inp, List<Integer> res) {
        this.inp = inp;
        this.res = res;
    }

    @Test
    public void spiralOrderTest() {
        List<Integer> got = matrixSpiralPrint.spiralOrder(this.inp);
        assertEquals(res, got);
    }
}
