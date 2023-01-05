package com.ajd.prep.dsa.graph.bellmanfrod;

import com.sun.jdi.connect.spi.TransportService;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class NumberOfRegions {
    public int regionsBySlashes(String[] grid) {
        int totalVertex = 4 * grid.length * grid.length;
        Set<Integer>[] graph = new HashSet[totalVertex];

        FindAndJoin fj = new FindAndJoin(totalVertex);


        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                char c = grid[i].charAt(j);

                int p = (grid.length * 4 * i) + (j * 4);
                int left = p;
                int right = p+1;
                int top = p+2;
                int bottom = p+3;

                if(c == '/') {
                    fj.join(left, top);
                    fj.join(right, bottom);
                } else if(c == '\\') {
                   fj.join(top, right);
                   fj.join(bottom, left);
                } else {
                    fj.join(left, top);
                    fj.join(left, bottom);
                    fj.join(left, right);

                    fj.join(top, bottom);
                    fj.join(top, right);

                    fj.join(right, bottom);
                }

                if(i > 0) {
                    int topBox = (grid.length * 4 * (i-1)) + (j * 4);
                    int topBoxBottom = topBox+3;
                    fj.join(topBoxBottom, top);
                }

                if(j > 0) {
                    int leftBox = (grid.length * 4 * i) + ((j-1) * 4);
                    int leftBoxRight = leftBox+1;
                    fj.join(leftBoxRight, left);
                }
            }
        }

        Set<Integer> roots = new HashSet<>();
        for(int i = 0; i < totalVertex; i++) {
            roots.add(fj.find(i));
        }

        return roots.size();
    }

}

class FindAndJoin {

    private int[] root;
    private int[] rank;

    FindAndJoin(int n) {
        root = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if(root[x] == x)
            return x;

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