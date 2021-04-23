package com.soulmate.practice;

public class P24 {

    public ListNode swapPairs(ListNode head) {
        ListNode first=head,second=null;
        while (first!=null&&first.next!=null){
            if(second==null)
                head=first.next;
            else
                second.next.next=first.next;
            second=first.next;
            first.next=second.next;
            second.next=first;
            first=first.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
