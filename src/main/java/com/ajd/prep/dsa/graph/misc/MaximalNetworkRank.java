package com.ajd.prep.dsa.graph.misc;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        Set<Integer>[] graph = new HashSet[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }

        int[] indegree = new int[n];

        for(int[] road : roads) {
            int src = road[0];
            int dst = road[1];

            indegree[src]++;
            indegree[dst]++;
            graph[src].add(dst);
            graph[dst].add(src);
        }

        int fm = 0, sm = 0, fmN = 0, smN = 0;
        for(int i = 0; i < n; i++) {
            int deg = indegree[i];
            if(deg > fm) {
                sm = fm;
                fm = deg;

                smN = fmN;
                fmN = i;

            } else if(deg > sm) {
                sm = deg;
                smN = i;
            }
        }

        log.info("fm: {}, fmN: {}, sm: {}, smN: {}", fm, fmN, sm, smN);
        return graph[fmN].contains(smN) ? fm + sm - 1 : fm + sm;
    }
}
