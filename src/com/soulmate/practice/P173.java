package com.soulmate.practice;

import java.util.LinkedList;

public class P173 {

    class BSTIterator {

        private LinkedList<Integer> list;

        public BSTIterator(TreeNode root) {
            list=new LinkedList<>();
            list.add(-1);
            func(root);
        }

        private void func(TreeNode node){
            if(node!=null){
                func(node.left);
                list.add(node.val);
                func(node.right);
            }
        }

        public int next() {
            return list.remove(1);
        }

        public boolean hasNext() {
            return list.size()>1;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
