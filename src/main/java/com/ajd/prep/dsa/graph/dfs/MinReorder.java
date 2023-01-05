package com.ajd.prep.dsa.graph.dfs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinReorder {
    public int minReorder(int n, int[][] connections) {

        Set<Integer>[] graph = new HashSet[n];
        Set<Integer>[] udGraph = new HashSet[n];
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
            udGraph[i] = new HashSet<>();
        }
        for(int[] connection : connections) {
            int src = connection[0];
            int dst = connection[1];

            graph[src].add(dst);
            udGraph[src].add(dst);
            udGraph[dst].add(src);
        }

        int res = 0;
        Stack<Integer> s = new Stack<>();
        s.push(0);

        while(!s.isEmpty()) {
            int node = s.pop();
            visited[node] = true;

            for(int neigh : udGraph[node]) {
                if(!visited[neigh]) {
                    s.push(neigh);
                    if(graph[node].contains(neigh)) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
}
