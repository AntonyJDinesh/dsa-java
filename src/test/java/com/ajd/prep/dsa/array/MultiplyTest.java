package com.ajd.prep.dsa.array;

import com.ajd.prep.dsa.array.DutchNationalFlag012;
import com.ajd.prep.dsa.array.Multiply;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@Slf4j
@RunWith(Parameterized.class)
public class MultiplyTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                {new int[]{9}, new int[]{9}, new int[]{8, 1}},
                {new int[]{1, 0}, new int[]{1, 0}, new int[]{1, 0, 0}},
                {new int[]{-1, 0}, new int[]{1, 0}, new int[]{-1, 0, 0}},
                {new int[]{1, 0}, new int[]{-1, 0}, new int[]{-1, 0, 0}},
                {new int[]{-1, 0}, new int[]{-1, 0}, new int[]{1, 0, 0}},
        });
    }

    // 5 -1 5 5 -1 5

    private Multiply multiply = new Multiply();
    private int[] a, b, res;

    public MultiplyTest(int[] a, int[] b, int[] res) {
        this.a = a;
        this.b = b;
        this.res = res;
    }

    @Test
    public void reorderEvenFirstTest() {
        int[] got = multiply.multiply(this.a, this.b);
        // log.info("got: {}", got);
        assertArrayEquals(res, got);
    }
}
