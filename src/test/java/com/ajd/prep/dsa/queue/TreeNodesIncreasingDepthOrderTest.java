package com.ajd.prep.dsa.queue;

import com.ajd.prep.dsa.stack.ValidParentheses;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@RunWith(Parameterized.class)
public class TreeNodesIncreasingDepthOrderTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        TreeNode<Integer> node17 = new TreeNode<>(17, null, null);
        TreeNode<Integer> node3 = new TreeNode<>(3, node17, null);
        TreeNode<Integer> node561 = new TreeNode<>(561, null, node3);

        TreeNode<Integer> node28 = new TreeNode<>(28, null, null);
        TreeNode<Integer> node0 = new TreeNode<>(0, null, null);
        TreeNode<Integer> node271 = new TreeNode<>(271, node28, node0);

        TreeNode<Integer> node6 = new TreeNode<>(6, node271, node561);

        TreeNode<Integer> node641 = new TreeNode<>(641, null, null);
        TreeNode<Integer> node401 = new TreeNode<>(401, null, node641);
        TreeNode<Integer> node257 = new TreeNode<>(257, null, null);
        TreeNode<Integer> node1 = new TreeNode<>(1, node401, node257);
        TreeNode<Integer> node2 = new TreeNode<>(2, null, node1);

        TreeNode<Integer> node28_1 = new TreeNode<>(28, null, null);
        TreeNode<Integer> node271_1 = new TreeNode<>(271, null, node28_1);
        TreeNode<Integer> node6_1 = new TreeNode<>(6, node2, node271_1);

        TreeNode<Integer> node314 = new TreeNode<>(314, node6, node6_1);

        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(new Integer[]{314}));
        res.add(Arrays.asList(new Integer[]{6, 6}));
        res.add(Arrays.asList(new Integer[]{271, 561, 2, 271}));
        res.add(Arrays.asList(new Integer[]{28, 0, 3, 1, 28}));
        res.add(Arrays.asList(new Integer[]{17, 401, 257}));
        res.add(Arrays.asList(new Integer[]{641}));

        return Arrays.asList(new Object[][] {
                {node314, res},
        });
    }

    private TreeNodesIncreasingDepthOrder treeNodesIncreasingDepthOrder = new TreeNodesIncreasingDepthOrder();
    private TreeNode<Integer> inp;
    private List<List<Integer>> res;

    public TreeNodesIncreasingDepthOrderTest(TreeNode<Integer> inp, List<List<Integer>> res) {
        this.inp = inp;
        this.res = res;
    }

    @Test
    public void getIncreasingDepthOrderTest() {
        List<List<Integer>> got = treeNodesIncreasingDepthOrder.getIncreasingDepthOrder(this.inp);
        assertEquals(res, got);
    }
}
