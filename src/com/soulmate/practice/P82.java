package com.soulmate.practice;

public class P82 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
            return head;

        ListNode res=null,prev=null,curr=head,next=curr.next;
        while (curr!=null&&next!=null){
            if(res==null&&prev!=null)
                res=prev;
            if(curr.val==next.val){
                int cmp=next.val;
                next=next.next;
                curr=null;
                while (next!=null){
                    if(next.val!=cmp)
                        break;
                    else
                        next=next.next;
                }
                if(next==null){
                    if(prev!=null)
                        prev.next=null;
                }else {
                    curr=next;
                    next=next.next;
                    if(prev!=null)
                        prev.next=curr;
                }
            }else {
                prev=curr;
                curr=curr.next;
                next=next.next;
            }
        }
        if(res==null&&prev!=null)
            return prev;
        if(res==null&&curr!=null)
            return curr;
        return res;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
