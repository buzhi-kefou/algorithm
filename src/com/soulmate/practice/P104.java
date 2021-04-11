package com.soulmate.practice;

public class P104 {

    public int maxDepth(TreeNode root) {
        return func(root,0);
    }

    private int func(TreeNode node,int tmp){
        if(node==null){
            return tmp;
        }else {
            tmp++;
            int l=func(node.left,tmp);
            int r=func(node.right,tmp);
            return l>r?l:r;
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