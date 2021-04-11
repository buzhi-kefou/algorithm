package com.soulmate.practice;

public class P86 {

    public ListNode partition(ListNode head, int x) {
        ListNode res=head,min=null,max=null,first=null;
        while (head!=null){
            if(head.val<x){
                if(min==null){
                    min=head;
                    res=head;
                }else {
                    min.next=head;
                    min=min.next;
                }
            }else {
                if(max==null){
                    first=head;
                    max=head;
                }else {
                    max.next=head;
                    max=max.next;
                }
            }
            head=head.next;
        }
        if(min!=null&&first!=null){
            min.next=first;
        }
        if(max!=null){
            max.next=null;
        }
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
