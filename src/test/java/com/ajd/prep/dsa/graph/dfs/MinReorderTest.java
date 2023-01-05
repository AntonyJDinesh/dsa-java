package com.ajd.prep.dsa.graph.dfs;

import com.ajd.prep.dsa.graph.bellmanfrod.NumberOfRegions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class MinReorderTest {


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[][]{{0,1}, {1,3}, {2,3}, {4,0}, {4,5}}, 6, 3},
                {new int[][]{{1,0}, {1,2}, {3,2}, {3,4}}, 5, 2},
        });
    }

    private MinReorder minReorder = new MinReorder();
    private int[][] connections;
    private int n;
    private int res;

    public MinReorderTest(int[][] connections, int n, int res) {
        this.connections = connections;
        this.n = n;
        this.res = res;
    }

    @Test
    public void minReorderTest() {
        int got = minReorder.minReorder(this.n, this.connections);
        assertEquals(res, got);
    }
}
