package com.soulmate.practice;

public class P98 {

    public boolean isValidBST(TreeNode root) {
        return func(root);
    }

    private boolean func(TreeNode node){
        if(node==null)
            return true;

        boolean l,r;
        l=func(node.left);
        r=func(node.right);
        if(!l||!r)
            return false;

        if(node.left!=null){
            int max = findMax(node);
            if(node.val<=max)
                l=false;
        }
        if(node.right!=null){
            int min = findMin(node);
            if(node.val>=min)
                r=false;
        }

        if(!l||!r)
            return false;
        else
            return true;
    }

    private int findMax(TreeNode node){
        if(node==null)
            return Integer.MIN_VALUE;
        node=node.left;
        while (node.right!=null){
            node=node.right;
        }
        return node.val;
    }

    private int findMin(TreeNode node){
        if(node==null)
            return Integer.MIN_VALUE;
        node=node.right;
        while (node.left!=null){
            node=node.left;
        }
        return node.val;
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
