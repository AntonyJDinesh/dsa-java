package com.ajd.prep.dsa.array;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class Multiply {

    public int[] multiply(int[] a, int[] b) {
        int sign = 1;
        if(a[0]*b[0] < 0) {
            sign = -1;
        }
        a[0] = Math.abs(a[0]);
        b[0] = Math.abs(b[0]);

        ArrayList<Integer>[] tmpRes = new ArrayList[b.length];
        int p = 0, maxSize = 0;

        for(int i = b.length-1; i > -1; i--, p++) {
            tmpRes[p] = multiply(a, b[i], p);
            maxSize = Math.max(maxSize, tmpRes[p].size());
        }

        // log.info("tmpRes: {}", tmpRes);
        ArrayList<Integer> res = new ArrayList<>();
        int carry = 0;

        for(int i = 0; i < maxSize; i++) {
            int sum = carry;
            for(int j = 0; j < tmpRes.length; j++) {
                if(tmpRes[j].size() > i) {
                    sum += tmpRes[j].get(i);
                }
            }

            res.add(sum%10);
            carry = sum / 10;
        }

        // log.info("res: {}", res);
        int[] resArr = new int[res.size()];
        for(int i = res.size()-1, j = 0; i > -1; i--, j++) {
            resArr[j] = res.get(i);
        }

        resArr[0] *= sign;
        return resArr;
    }

    private ArrayList<Integer> multiply(int[] a, int b, int p) {

        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < p; i++) {
            res.add(0);
        }

        int carry = 0;
        for(int i = a.length-1; i > -1; i--) {
            int tmp = a[i] * b + carry;
            res.add(tmp%10);
            carry = tmp/10;
        }

        while(carry > 0) {
            res.add(carry%10);
            carry /= 10;
        }


        return res;
    }
}
