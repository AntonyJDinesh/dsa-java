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
public class PermutateArrayElementTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                {new int[]{2, 0, 1, 3}, new char[]{'a', 'b', 'c', 'd'}, new char[]{'b', 'c', 'a', 'd'}},

        });
    }

    private PermutateArrayElement permutateArrayElementTest = new PermutateArrayElement();
    private int[] pos;
    private char[] inp, res;

    public PermutateArrayElementTest(int[] pos, char[] inp, char[] res) {
        this.inp = inp;
        this.res = res;
        this.pos = pos;
    }

    @Test
    public void permutate() {
        char[] got = permutateArrayElementTest.permutate1(this.inp, this.pos);
        log.info("got: {}", got);
        assertArrayEquals(res, got);
    }
}
