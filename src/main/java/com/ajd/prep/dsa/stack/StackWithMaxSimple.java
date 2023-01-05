package com.ajd.prep.dsa.stack;

public class StackWithMaxSimple<T extends Comparable> {

    private Node<T> root;

    public void push(T val) {
        T max = val;

        if(!isEmpty() && val.compareTo(max()) < 1) {
            max = max();
        }

        Node<T> newNode = new Node(val, max, root);
        root = newNode;
    }

    public T pop() {
        if(isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        Node<T> removed = root;
        root = root.next;
        removed.next = null;

        return removed.val;
    }

    public T max() {
        if(isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return root.max;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private static class Node<T> {
        private T val, max;
        private Node<T> next;
        Node(T val, T max, Node<T> next) {
            this.val = val;
            this.max = max;
            this.next = next;
        }
    }
}
