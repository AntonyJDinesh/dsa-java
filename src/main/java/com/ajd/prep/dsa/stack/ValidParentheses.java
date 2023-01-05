package com.ajd.prep.dsa.stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()) {
            if(isOpenParantheses(c)) {
                stack.push(c);
            } else {
                char open = stack.pop();
                if( (c == ')' && open == '(') ||  (c == ']' && open == '[') || (c == '}' && open == '{') ) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }

    private static boolean isOpenParantheses(char c) {
        return c == '(' || c == '{' || c == '[';
    }
}
