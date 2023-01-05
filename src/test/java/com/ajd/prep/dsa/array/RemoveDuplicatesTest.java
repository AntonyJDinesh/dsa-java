package com.ajd.prep.dsa.array;

import com.ajd.prep.dsa.array.AdvanceThroughArray;
import com.ajd.prep.dsa.array.RemoveDuplicates;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@RunWith(Parameterized.class)
public class RemoveDuplicatesTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                {new int[]{1, 2, 3}, 3},
                {new int[]{1, 2, 3, 3}, 3},
                {new int[]{1, 1, 1, 1, 1}, 1},
                {new int[]{1, 2, 3, 5, 5, 7, 11, 11, 11, 13}, 7},
        });
    }

    private RemoveDuplicates removeDuplicates = new RemoveDuplicates();
    private int[] inp;
    private int res;

    public RemoveDuplicatesTest(int[] inp, int res) {
        this.inp = inp;
        this.res = res;
    }

    @Test
    public void reorderEvenFirstTest() {
        // int got = advanceThroughArray.findMinMovesDP1(this.inp);
        int got = removeDuplicates.removeDuplicates1(this.inp);
        assertEquals(res, got);
    }
}
