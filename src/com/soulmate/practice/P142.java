package com.soulmate.practice;

public class P142 {

    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode slow=head,fast=head.next;
        while (fast!=null&&fast.next!=null){
            if(fast==slow){
                fast=head;
                slow=slow.next;
                while (fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return slow;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
