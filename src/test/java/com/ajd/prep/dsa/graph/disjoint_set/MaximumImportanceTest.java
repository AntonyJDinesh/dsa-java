package com.ajd.prep.dsa.graph.disjoint_set;

import com.ajd.prep.dsa.graph.dfs.MinReorder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class MaximumImportanceTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[][]{{0,1}, {1,2}, {2,3}, {0,2}, {1,3}, {2,4}}, 5, 43},
                {new int[][]{{0,3}, {2,4}, {1,3}}, 5, 20},
        });
    }


    private MaximumImportance maximumImportance = new MaximumImportance();
    private int[][] roads;
    private int n;
    private int res;

    public MaximumImportanceTest(int[][] roads, int n, int res) {
        this.roads = roads;
        this.n = n;
        this.res = res;
    }

    @Test
    public void minReorderTest() {
        long got = maximumImportance.maximumImportance(this.n, this.roads);
        assertEquals(res, got);
    }

}
