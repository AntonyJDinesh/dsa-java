package com.ajd.prep.dsa.linkedlist;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CommonInTwoSortedList {
    public List<Integer> getCommonElements(ListNode head1, ListNode head2) {

        List<Integer> res = new ArrayList<>();
        while(head1 != null && head2 != null) {
            // log.info("l1: {}; l2: {}", head1.val, head2.val);
            if(head1.val == head2.val) {
                res.add(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            } else if(head1.val < head2.val) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }

            // log.info("h1: {}; h2: {}", head1, head2);
        }

        return res;
    }
}
