package com.ajd.prep.dsa.queue;

import lombok.Data;

@Data
public class TreeNode<T> {
    private T val;
    private TreeNode<T> left, right;

    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
