package com.soulmate.practice;

public class P450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node=root,parent=null;
        while (node!=null){
            if(node.val==key){
                root=func(key,parent,root);
                break;
            }
            parent=node;
            if(node.val<key){
                node=node.right;
            }else {
                node=node.left;
            }
        }
        return root;
    }

    private TreeNode func(int key,TreeNode parent,TreeNode root){
        if(parent!=null){
            TreeNode del;
            if(parent.left!=null&&parent.left.val==key){
                del=parent.left;
                if(del.left!=null&&del.right!=null) {
                    parent.left=del.left;
                    TreeNode fast=del.left;
                    while (fast.right!=null)
                        fast=fast.right;
                    fast.right=del.right;
                }else {
                    if(del.left==null)
                        parent.left=del.right;
                    else
                        parent.left=del.left;
                }
            }else {
                del=parent.right;
                if(del.left!=null&&del.right!=null) {
                    parent.right=del.left;
                    TreeNode fast=del.left;
                    while (fast.right!=null)
                        fast=fast.right;
                    fast.right=del.right;
                }else {
                    if(del.left==null)
                        parent.right=del.right;
                    else
                        parent.right=del.left;
                }
            }
        }else {
            if(root.left!=null&&root.right!=null){
                TreeNode fast=root.left;
                while (fast.right!=null)
                    fast=fast.right;
                fast.right=root.right;
                root=root.left;
            }else {
                if(root.left==null)
                    root=root.right;
                else
                    root=root.left;
            }
        }
        return root;
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
