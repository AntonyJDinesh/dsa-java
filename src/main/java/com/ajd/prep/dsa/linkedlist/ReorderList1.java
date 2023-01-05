package com.ajd.prep.dsa.linkedlist;

public class ReorderList1 {
    public ListNode reorder(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head, slowPrev = null;
        while(fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null) {
            slowPrev = slow;
            slow = slow.next;
        }

        // 1 2 3 4
        slowPrev.next = null;
        ListNode head1 = head, head2 = slow;
        while(head1 != null && head2 != null) {
            ListNode tmp1 = head1.next, tmp2 = head2.next;
            head1 = head1.next;
            head2 = head2.next;
        }

        return head;
    }
}
