package com.soulmate.practice;

public class P234 {

    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;
        ListNode reverse=new ListNode();
        ListNode slow=head,fast=head.next;
        while (fast!=null&&fast.next!=null){
            ListNode temp=reverse,prev=reverse.next;
            ListNode next=slow.next;
            fast=fast.next.next;
            slow.next=prev;
            temp.next=slow;
            slow=next;
        }
        if(reverse.next==null)
            return head.val==head.next.val;
        if(fast!=null){
            ListNode temp=reverse,prev=reverse.next;
            ListNode next=slow.next;
            slow.next=prev;
            temp.next=slow;
            slow=next;
        }else {
            slow=slow.next;
        }
        reverse=reverse.next;
        while (slow!=null){
            if(slow.val!=reverse.val)
                return false;
            reverse=reverse.next;
            slow=slow.next;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
