package com.ajd.prep.dsa.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodesIncreasingDepthOrder {

    public List<List<Integer>> getIncreasingDepthOrder(TreeNode<Integer> root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode<Integer>> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {
            int len = q.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < len; i++) {
                TreeNode<Integer> cur = q.remove();
                tmp.add(cur.getVal());

                if(cur.getLeft() != null)
                    q.add(cur.getLeft());
                if(cur.getRight() != null)
                    q.add(cur.getRight());
            }

            res.add(tmp);
        }

        return res;
    }
}
