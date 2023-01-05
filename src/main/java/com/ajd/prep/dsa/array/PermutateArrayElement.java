package com.ajd.prep.dsa.array;

public class PermutateArrayElement {
    public char[] permutate(char[] inp, int[] pos) {
        char[] res = new char[pos.length];

        for(int i = 0; i < pos.length; i++) {
            res[pos[i]] = inp[i];
        }

        return res;
    }

    public char[] permutate1(char[] inp, int[] pos) {

        for(int i = 0; i < pos.length; i++) {
            if(pos[i] == -1 || i == pos[i]) {
                continue;
            }
            permutate1(inp, pos, i);
        }
        return inp;
    }

    private void permutate1(char[] inp, int[] pos, int start) {
        // [2, 0, 1, 3]
        // [a, b, c, d]

        // start = 0
        // startChar = a;

        // loop: start = 0; pos[0] != -1 (2 != -1)
        //  tmp = c
        //  inp[2] = a; [a, b, a, d]
        //  startChar = c

        // tmpStart = 0;
        // start = 2
        // pos[0] = -1; [-1, 0, 1, 3]

        // loop: pos[2] != -1; 1 != -1
        // tmp = inp[1]; tmp = b
        // inp[1] = c; [a, c, a, d]
        // startChar = b;
        // tmpStart = 2
        // start = pos[2]; start = 1
        // pos[2] = -1; [-1, 0, -1, 3]

        // loop: pos[1] != -1; 0 != -1
        // tmp = inp[0]; tmp = a;
        // inp[0] = b; [b, c, a, d]
        // startChar = a;
        // tmpStart = 1
        // start = pos[1]; start = 0
        // pos[1] = -1; [-1, -1, -1, 3]

        // loop: pos[0] != -1; -1 != -1



        char startChar = inp[start];
        while(pos[start] != -1) {
            char tmp = inp[pos[start]];
            inp[pos[start]] = startChar;
            startChar = tmp;

            int tmpStart = start;
            start = pos[start];
            pos[tmpStart] = -1;
        }
    }
}
