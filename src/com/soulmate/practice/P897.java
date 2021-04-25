package com.soulmate.practice;

import java.util.LinkedList;

public class P897 {
    LinkedList<TreeNode> list = new LinkedList<>();

    public TreeNode increasingBST(TreeNode root) {
        func(root);
        return list.getFirst();
    }

    private void func(TreeNode node){
        if(node==null)
            return;
        if(node.left==null&&node.right==null){
            if(!list.isEmpty())
                list.getLast().right=node;
            list.addLast(node);
        }else {
            func(node.left);
            node.left=null;
            if(!list.isEmpty())
                list.getLast().right=node;
            list.addLast(node);
            func(node.right);
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
