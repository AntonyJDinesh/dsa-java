package com.ajd.prep.dsa.matrix;

public class MatrixRotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0; i < n/2; i++) {
            int N = n-i-1;
            for(int j = i, k = 0; j < N; j++, k++) {

                int topLeft = matrix[i][j];
                int topRight = matrix[j][N];
                int bottomRight = matrix[N][N-k];
                int bottomLeft = matrix[N-k][i];


                matrix[j][N] = topLeft;
                matrix[N][N-k] = topRight;
                matrix[N-k][i] = bottomRight;
                matrix[i][j] = bottomLeft;
            }
        }
    }
}
