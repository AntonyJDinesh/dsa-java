package com.ajd.prep.dsa.graph.misc;

import com.ajd.prep.dsa.graph.disjoint_set.MaximumImportance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class MaximalNetworkRankTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[][]{{0,1}, {1,2}, {2,3}, {2,4}, {5,6}, {5,7}}, 8, 5},
        });
    }


    private MaximalNetworkRank maximalNetworkRank = new MaximalNetworkRank();
    private int[][] roads;
    private int n;
    private int res;

    public MaximalNetworkRankTest(int[][] roads, int n, int res) {
        this.roads = roads;
        this.n = n;
        this.res = res;
    }

    @Test
    public void minReorderTest() {
        long got = maximalNetworkRank.maximalNetworkRank(this.n, this.roads);
        assertEquals(res, got);
    }
}
