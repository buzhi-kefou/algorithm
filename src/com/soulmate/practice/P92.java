package com.soulmate.practice;

public class P92 {

    int right;
    ListNode res,prev,next,temp;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        this.right=right;
        for (int i = 1; i < left; i++) {
            if(res==null)
                res=head;
            prev=head;
            head=head.next;
        }
        temp = func(head, left);
        temp.next=next;
        return res;
    }

    private ListNode func(ListNode node,int right){
        if(right!=this.right){
            temp = func(node.next, right + 1);
            temp.next=node;
            temp=temp.next;
        }else {
            if(res==null)
                res=node;
            if(prev!=null)
                prev.next=node;
            next=node.next;
            temp=node;
        }
        return temp;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
