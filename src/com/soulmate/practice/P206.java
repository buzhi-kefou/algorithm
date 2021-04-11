package com.soulmate.practice;

public class P206 {

    ListNode res=null;

    public ListNode reverseList(ListNode head) {
        if (head==null)
            return null;
        func(res,head);
        head.next=null;
        return res;
    }

    private ListNode func(ListNode head, ListNode node){
        if(node.next!=null){
            head=func(head,node.next);
            head.next=node;
            head=head.next;
            return head;
        }else {
            res=node;
            return res;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
