package com.soulmate.practice;

public class P110 {

    public boolean isBalanced(TreeNode root) {
        int func = func(root);
        return func!=-1;
    }

    private int func(TreeNode node){
        if(node==null){
            return 1;
        }else {
            int l=func(node.left);
            if(l==-1)
                return -1;
            int r=func(node.right);
            if(r==-1)
                return -1;
            if(l>r)
                return l-r>1?-1:l+1;
            else
                return r-l>1?-1:r+1;
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