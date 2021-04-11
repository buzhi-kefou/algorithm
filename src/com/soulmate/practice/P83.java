package com.soulmate.practice;

public class P83 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode curr=head,next=head.next;
        while (curr!=null&&next!=null){
            if(curr.val==next.val)
                curr.next=next.next;
            else
                curr=curr.next;
            next=next.next;
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
