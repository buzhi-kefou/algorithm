package com.soulmate.practice;

import java.util.LinkedList;

public class P61 {

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        LinkedList<ListNode> list = new LinkedList<>();
        ListNode curr=head;
        while (curr!=null){
            list.add(curr);
            curr=curr.next;
        }
        ListNode tail=list.get(list.size()-k%list.size()-1);
        list.getLast().next=head;
        ListNode temp=tail.next;
        tail.next=null;
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
