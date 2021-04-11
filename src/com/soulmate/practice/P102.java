package com.soulmate.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root==null)
            return res;
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()){
            Result result = func(list, list.size());
            res.add(result.list);
            list=result.nodes;
        }
        return res;
    }

    private Result func(List<TreeNode> list,int size){
        ArrayList<Integer> res = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            res.add(list.get(i).val);
            if(list.get(i).left!=null)
                list.add(list.get(i).left);
            if(list.get(i).right!=null)
                list.add(list.get(i).right);
        }

        return new Result(res,list.subList(size,list.size()));
    }

    static class Result{
        List<Integer> list;
        List<TreeNode> nodes;
        public Result(List<Integer> list,List<TreeNode> nodes){
            this.list=list;
            this.nodes=nodes;
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
