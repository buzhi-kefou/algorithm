package com.soulmate.practice;

import java.util.LinkedList;
import java.util.List;

public class P94 {

    private List<Integer> res=new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        func(root);
        return res;
    }

    private void func(TreeNode node){
        if(node!=null){
            func(node.left);
            res.add(node.val);
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
