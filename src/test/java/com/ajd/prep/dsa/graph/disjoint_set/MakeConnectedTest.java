package com.ajd.prep.dsa.graph.disjoint_set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class MakeConnectedTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[][]{{0,1}, {0,2}, {1,2}}, 4, 1},
                {new int[][]{{0,1}, {0,2}, {0,3}, {1,2}, {1,3}}, 6, 2},
                {new int[][]{{0,1}, {0,2}, {0,3}, {1,2}}, 6, -1},
        });
    }


    private MakeConnected makeConnected = new MakeConnected();
    private int[][] connections;
    private int n;
    private int res;

    public MakeConnectedTest(int[][] connections, int n, int res) {
        this.connections = connections;
        this.n = n;
        this.res = res;
    }

    @Test
    public void makeConnectedTest() {
        long got = makeConnected.makeConnected(this.n, this.connections);
        assertEquals(res, got);
    }
}
