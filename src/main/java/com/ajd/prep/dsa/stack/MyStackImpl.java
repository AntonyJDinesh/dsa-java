package com.ajd.prep.dsa.stack;

import java.util.Stack;

public class MyStackImpl<T> {

    private StackNode<T> root;
    private Stack stack;

    public MyStackImpl() {}

    public void push(T val) {
        this.root = new StackNode<>(val, root);
    }

    public T pop() {
        if(root == null) {
            throw new RuntimeException("Stack is empty.");
        }

        StackNode<T> ret = root;
        root = root.next;
        ret.next = null;

        return ret.val;
    }

    public T peek() {
        if(root == null) {
            throw new RuntimeException("Stack is empty.");
        }

        return this.root.val;
    }

    private static class StackNode<T> {
        private T val;
        private StackNode next;

        StackNode(T val, StackNode<T> next) {
            this.val = val;
            this.next = next;
        }
    }
}
