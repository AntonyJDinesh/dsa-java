package com.ajd.prep.dsa.linkedlist;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static boolean isEqual(ListNode h1, ListNode h2) {
        while(h1 != null && h2 != null) {
            if(h1.val != h2.val) {
                return false;
            }

            h1 = h1.next;
            h2 = h2.next;
        }

        return (h1 == null && h2 == null) ? true: false;
    }
}
