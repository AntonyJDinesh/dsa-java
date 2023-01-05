package com.ajd.prep.dsa.stack;

public class StackWithMax<T extends Comparable> {

    private Node<T> stackRoot, maxRoot;

    public void push(T val) {
        Node<T> maxPrev = null, maxCurr = maxRoot;
        while(maxCurr != null && val.compareTo(maxCurr.val) < 1) {
            maxPrev = maxCurr;
            maxCurr = maxCurr.maxNext;
        }

        Node<T> newNode = new Node<>(val, stackRoot, maxCurr, maxPrev);

        stackRoot = newNode;
        if(maxPrev != null) {
            maxPrev.maxNext = newNode;
        } else {
            maxRoot = newNode;
        }
    }

    public T pop() {
        if(stackRoot == null) {
            throw new RuntimeException("stack is empty");
        }
        Node<T> removed = stackRoot;
        stackRoot = removed.stackNext;
        removed.stackNext = null;

        // manage max links
        if(removed.maxPrev != null) {
            removed.maxPrev.maxNext = removed.maxNext;
        } else {
            maxRoot = removed.maxNext;
        }

        if(removed.maxNext != null) {
            removed.maxNext.maxPrev = removed.maxPrev;
        }

        return removed.val;
    }

    public T max() {
        return maxRoot.val;
    }

    private static class Node<T> {
        private T val;
        private Node<T> stackNext, maxPrev, maxNext;

        Node(T val, Node<T> stackNext, Node<T> maxNext, Node<T> maxPrev) {
            this.val = val;
            this.stackNext = stackNext;
            this.maxNext = maxNext;
            this.maxPrev = maxPrev;
        }
    }
}
