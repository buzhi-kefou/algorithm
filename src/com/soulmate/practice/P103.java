package com.soulmate.practice;

import java.util.LinkedList;
import java.util.List;

public class P103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root==null)
            return res;
        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        boolean flag=true;
        while (!nodes.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int size=nodes.size();
            LinkedList<TreeNode> temp = new LinkedList<>();
            for (TreeNode node : nodes) {
                list.add(node.val);
                if(flag){
                    if(node.left!=null)
                        temp.addFirst(node.left);
                    if(node.right!=null)
                        temp.addFirst(node.right);
                }else {
                    if(node.right!=null)
                        temp.addFirst(node.right);
                    if(node.left!=null)
                        temp.addFirst(node.left);
                }
            }
            nodes=temp;
            res.add(list);
            flag=(flag!=true);
        }

        return res;
    }

    class TreeNode {
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
