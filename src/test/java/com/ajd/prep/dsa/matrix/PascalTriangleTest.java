package com.ajd.prep.dsa.matrix;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@RunWith(Parameterized.class)
public class PascalTriangleTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        List<Integer> row1 = new ArrayList<>();
        row1.add(1);

        List<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(1);

        List<Integer> row3 = new ArrayList<>();
        row3.add(1);
        row3.add(2);
        row3.add(1);

        List<Integer> row4 = new ArrayList<>();
        row4.add(1);
        row4.add(3);
        row4.add(3);
        row4.add(1);

        List<Integer> row5 = new ArrayList<>();
        row5.add(1);
        row5.add(4);
        row5.add(6);
        row5.add(4);
        row5.add(1);

        return Arrays.asList(new Object[][] {
                {5, Arrays.asList(row1, row2, row3, row4, row5)},
                {1, Arrays.asList(row1)},
        });
    }

    private PascalTriangle pascalTriangle = new PascalTriangle();
    private List<List<Integer>> res;
    private int inp;

    public PascalTriangleTest(int inp, List<List<Integer>> res) {
        this.inp = inp;
        this.res = res;
    }

    @Test
    public void spiralOrderTest() {
        List<List<Integer>> got = pascalTriangle.generate(this.inp);
        log.info("got: {}", got);
        assertEquals(res, got);
    }
}
