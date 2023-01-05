package com.ajd.prep.dsa.matrix;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if(numRows == 0) {
            return res;
        }
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);

        res.add(row1);

        if(numRows == 1) {
            return res;
        }

        List<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(1);

        res.add(row2);

        if(numRows == 1) {
            return res;
        }

        for(int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            List<Integer> prevRow = res.get(i-1);
            row.add(1);
            for(int j = 1; j < i; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            row.add(1);
            res.add(row);
        }


        return res;
    }
}
