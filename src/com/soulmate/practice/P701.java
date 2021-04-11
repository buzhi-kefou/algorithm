package com.soulmate.practice;

import java.util.LinkedList;
import java.util.List;

public class P701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        func(root);
        if(list.isEmpty())
            return new TreeNode(val);

        int i = 0,size=list.size();
        if(list.get(i).val>val){
            list.get(i).left=new TreeNode(val);
            return root;
        }
        if(list.get(size-1).val<val){
            list.get(size-1).right=new TreeNode(val);
            return root;
        }
        for (; i < list.size(); i++) {
            if(list.get(i).val>val)
                break;
        }
        TreeNode temp = list.get(i - 1);
        if(temp.right==null)
            temp.right=new TreeNode(val);
        else {
            TreeNode node = new TreeNode(val);
            node.right=temp.right;
            temp.right=node;
        }
        return root;
    }

    List<TreeNode> list=new LinkedList<>();

    private void func(TreeNode node){
        if(node==null)
            return;
        func(node.left);
        list.add(node);
        func(node.right);
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
