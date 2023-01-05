package com.ajd.prep.dsa.graph.disjoint_set;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class MaximumImportance {
    public long maximumImportance(int n, int[][] roads) {
        long res = 0l;

        int[] deg = new int[n];
        for(int[] road : roads) {
            deg[road[0]]++;
            deg[road[1]]++;
        }

        Arrays.sort(deg);
        for(int i = 0; i < n; i++) {
            res +=  (i+1l) * deg[i];
        }

        return res;

    }
}