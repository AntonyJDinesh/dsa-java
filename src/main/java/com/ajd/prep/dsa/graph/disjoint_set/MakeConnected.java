package com.ajd.prep.dsa.graph.disjoint_set;

import java.util.HashSet;
import java.util.Set;

public class MakeConnected {
    public int makeConnected(int n, int[][] connections) {

        FindAndJoin fj = new FindAndJoin(n);
        int extraCables = 0;

        for(int[] connection : connections) {
            if(!fj.join(connection[0], connection[1])) {
                extraCables++;
            }
        }

        Set<Integer> roots = new HashSet<>();
        for(int i = 0; i < n; i++) {
            roots.add(fj.find(i));
        }

        int disConnectedNodes = roots.size()-1;

        return extraCables >= disConnectedNodes ? disConnectedNodes : -1;
    }
}

class FindAndJoin {

    private int[] rank, root;
    FindAndJoin(int n) {
        rank = new int[n];
        root = new int[n];

        for(int i = 0; i < n; i++) {
            rank[i] = 1;
            root[i] = i;
        }
    }

    public int find(int x) {
        if(x == root[x]) {
            return x;
        }

        root[x] = find(root[x]);
        return root[x];
    }

    public boolean join(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) {

            if(rank[rootX] >= rank[rootY]) {
                root[rootY] = rootX;
                rank[rootX] += rank[rootY];
            } else {
                root[rootX] = rootY;
                rank[rootY] += rank[rootX];
            }

            return true;
        }

        return false;
    }
}