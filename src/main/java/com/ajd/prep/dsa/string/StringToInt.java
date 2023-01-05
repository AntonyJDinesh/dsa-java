package com.ajd.prep.dsa.string;

import java.util.ArrayList;
import java.util.List;

public class StringToInt {
    public int myAtoi(String s) {
        int sign = 1;
        List<Integer> nums = new ArrayList<>();

        loop: for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case '0':
                    nums.add(0);
                    break;
                case '1':
                    nums.add(1);
                    break;
                case '2':
                    nums.add(2);
                    break;
                case '3':
                    nums.add(3);
                    break;
                case '4':
                    nums.add(4);
                    break;
                case '5':
                    nums.add(5);
                    break;
                case '6':
                    nums.add(6);
                    break;
                case '7':
                    nums.add(7);
                    break;
                case '8':
                    nums.add(8);
                    break;
                case '9':
                    nums.add(9);
                    break;
                case '-':
                    if(i < s.length()-1 && isNumber(s.charAt(i+1))) {
                        sign = -1;
                    }
                    break;
                case ' ':
                    break;
                default:
                    break loop;
            }
        }

        if(nums.size() == 0) {
            return 0;
        }

        long res = 0;
        for(int i = 0; i < nums.size(); i++) {
            res = res * 10 + nums.get(i);
        }

        return (int) res*sign;
    }

    private boolean isNumber(char c) {
        switch (c) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return true;
            default:
                return false;
        }
    }
}
