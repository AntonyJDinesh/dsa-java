package com.ajd.prep.dsa.graph.bellmanfrod;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class NumberOfRegionsTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new String[]{" /","/ "}, 2},
                {new String[]{" /","  "}, 1},
                {new String[]{"/\\","\\/"}, 5},
                {new String[]{"\\/\\ "," /\\/"," \\/ ","/ / "}, 3},
        });
    }

    private NumberOfRegions numberOfRegions = new NumberOfRegions();
    private String[] arg;
    private int res;

    public NumberOfRegionsTest(String[] arg, int res) {
        this.arg = arg;
        this.res = res;
    }

    @Test
    public void regionsBySlashes() {
        int got = numberOfRegions.regionsBySlashes(this.arg);
        assertEquals(res, got);
    }
}
