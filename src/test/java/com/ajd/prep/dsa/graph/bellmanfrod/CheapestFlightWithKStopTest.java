package com.ajd.prep.dsa.graph.bellmanfrod;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
@DisplayName("A special test case")
public class CheapestFlightWithKStopTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {4, new int[][]{{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}}, 0, 3, 1, 700},
                {4, new int[][]{{0,1,100}, {1,2,100}, {2,3,100}}, 0, 3, 1, -1},
                {4, new int[][]{{0,1,100}, {1,2,100}, {2,3,100}}, 0, 3, 2, 300},
        });
    }

    private int n, src, dst, k, expected;
    private int[][] flights;


    public CheapestFlightWithKStopTest(int n, int[][] flights, int src, int dst, int k, int expected) {
        this.n = n;
        this.src = src;
        this.dst = dst;
        this.k = k;
        this.expected = expected;
        this.flights = flights;
    }

    @Test
    @DisplayName("😱")
    public void cheapestFlightWithKStopTest() {
        assertEquals(expected, CheapestFlightWithKStop.cheapestFlightWithKStop(n, flights, src, dst, k));
    }
}
