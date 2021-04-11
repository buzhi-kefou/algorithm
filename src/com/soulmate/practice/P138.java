package com.soulmate.practice;

import java.util.ArrayList;
import java.util.HashMap;

public class P138 {

    public Node copyRandomList(Node head) {
        if (head==null)
            return null;
        Node res = new Node(head.val);
        Node temp=res,curr=head.next;

        HashMap<Node, Integer> cmp = new HashMap<>();
        ArrayList<Node> list = new ArrayList<>();
        cmp.put(head,0);
        list.add(res);
        int i=1;
        while (curr!=null){
            temp.next=new Node(curr.val);
            list.add(temp.next);
            cmp.put(curr,i++);
            temp=temp.next;
            curr=curr.next;
        }
        curr=res;
        while (head!=null){
            if(head.random!=null){
                Integer pos = cmp.get(head.random);
                curr.random=list.get(pos);
            }
            curr=curr.next;
            head=head.next;
        }
        return res;
    }

    static class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
