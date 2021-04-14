package com.soulmate.practice;

import java.util.*;

public class P208 {

    static class Node{
        int cnt;
        char val;
        HashMap<Character,Node> next;

        public Node(){
            next=new HashMap<>();
        }
        public Node(char v){
            val=v;
            next=new HashMap<>();
        }
    }

    static class Trie {

        private Node sub;

        /** Initialize your data structure here. */
        public Trie() {
            sub=new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node node;
            char c=word.charAt(0);
            if(!sub.next.containsKey(c))
                sub.next.put(c,new Node(c));
            node=sub.next.get(c);

            char[] chars = word.toCharArray();
            for(int i=1;i<chars.length;i++){
                if(!node.next.containsKey(chars[i])){
                    Node temp = new Node(chars[i]);
                    node.next.put(chars[i],temp);
                }
                node=node.next.get(chars[i]);
            }
            node.cnt++;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node node = sub.next.get(word.charAt(0));
            if(node==null)
                return false;
            char[] chars = word.toCharArray();
            for(int i=1;i<chars.length;i++){
                if(node.next.containsKey(chars[i]))
                    node=node.next.get(chars[i]);
                else
                    return false;
            }
            if (node.next.isEmpty()||node.cnt!=0)
                return true;
            return false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node node=sub;
            char[] chars = prefix.toCharArray();
            for (int i=0;i<chars.length;i++){
                if(!node.next.containsKey(chars[i]))
                    return false;
                node=node.next.get(chars[i]);
            }
            return true;
        }
    }

}
