package com.soulmate.practice;

import java.util.*;

public class P148 {

    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode p = head, q = head, m = head;
        int sum = 0;
        while(p != null){
            sum++;
            p = p.next;
        }
        int[] array = new int[sum];
        for(int i = 0;i<sum; i++){
            array[i] = q.val;
            q = q.next;
        }
        Arrays.sort(array);
        for(int i = 0;i<sum; i++){
            m.val = array[i];
            m = m.next;
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
