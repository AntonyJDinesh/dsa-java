package com.ajd.prep.dsa.stack;

import java.util.Stack;

public class RPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();

        for(String token : tokens) {
            if(isInteger(token)) {
                nums.push(Integer.parseInt(token));
            } else {
                int operand2 = nums.pop();
                int operand1 = nums.pop();
                switch(token) {
                    case "/":
                        nums.push(operand1/operand2);
                        break;
                    case "*":
                        nums.push(operand1 * operand2);
                        break;
                    case "+":
                        nums.push(operand1 + operand2);
                        break;
                    case "-":
                        nums.push(operand1 - operand2);
                        break;
                }
            }
        }

        return nums.pop();
    }


    private boolean isInteger(String str) {
        boolean ret = true;
        if( str.equals("-") || str.equals("+") || str.equals("*") || str.equals("/")) {
            ret = false;
        }

        return ret;
    }
}
