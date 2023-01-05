package com.ajd.prep.dsa.linkedlist;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@RunWith(Parameterized.class)
public class CommonInTowSortedListTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {



        ListNode l1n4 = new ListNode(4, null);
        ListNode l1n3 = new ListNode(3, l1n4);
        ListNode l1n2 = new ListNode(2, l1n3);
        ListNode l1n1 = new ListNode(1, l1n2);

        ListNode l2n3 = new ListNode(5, null);
        ListNode l2n2 = new ListNode(4, l2n3);
        ListNode l2n1 = new ListNode(2, l2n2);

        return Arrays.asList(new Object[][] {
                {l1n1, l2n1, Arrays.asList(new Integer[]{2, 4})},
        });
    }


    private CommonInTwoSortedList commonInTwoSortedList = new CommonInTwoSortedList();
    private ListNode head1, head2;
    private List<Integer> res;

    public CommonInTowSortedListTest(ListNode head1, ListNode head2, List<Integer> res) {
        this.head1 = head1;
        this.head2 = head2;
        // List<Integer> tmp = new ArrayList<>();
        this.res = res;
    }

    @Test
    public void minReorderTest() {
        List<Integer> got = commonInTwoSortedList.getCommonElements(this.head1, this.head2);
        assertEquals(res, got);
    }
}
