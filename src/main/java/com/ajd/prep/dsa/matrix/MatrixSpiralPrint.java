package com.ajd.prep.dsa.matrix;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MatrixSpiralPrint {

    enum DIRECTION {ROW_FORWARD, ROW_BACKWARD, COL_TO_BOTTOM, COL_TO_TOP}

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0) {
            return res;
        }

        int rowOffset = 0, colOffset = 0;
        int totalRows = matrix.length, totalCols = matrix[0].length;

        DIRECTION direction = DIRECTION.ROW_FORWARD;

        loop: for(int i = 0, row = 0, col = 0; i < totalRows*totalCols; i++) {
            res.add(matrix[row][col]);

            switch(direction) {
                case ROW_FORWARD:
                    if(col < totalCols-colOffset-1) {
                        col++;
                    } else {
                        direction = DIRECTION.COL_TO_BOTTOM;
                        row++;
                    }
                    break;
                case COL_TO_BOTTOM:
                    if(row < totalRows-rowOffset-1) {
                        row++;
                    } else {
                        direction = DIRECTION.ROW_BACKWARD;
                        rowOffset++;
                        col--;
                    }
                    break;
                case ROW_BACKWARD:
                    if(col > colOffset) {
                        col--;
                    } else {
                        direction = DIRECTION.COL_TO_TOP;
                        colOffset++;
                        row--;
                    }
                    break;
                case COL_TO_TOP:
                    if(row > rowOffset) {
                        row--;
                    } else {
                        direction = DIRECTION.ROW_FORWARD;
                        col++;
                    }
                    break;
            }
        }

        return res;
    }
}
