package com.soulmate.practice;

public class P143 {

    public void reorderList(ListNode head) {
        ListNode mid = getMidNode(head);
        ListNode rev = reverse(mid);
        while (rev != mid) {
            ListNode next1 = head.next;
            ListNode next2 = rev.next;
            head.next = rev;
            rev.next = next1;
            head = next1;
            rev = next2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
