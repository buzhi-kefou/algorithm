package com.soulmate.practice;

public class P124 {

    public int maxPathSum(TreeNode root) {
        Result result = func(root);
        return result.maxPath;
    }

    static class Result{
        int single;
        int maxPath;
        public Result(){}
        public Result(int a,int b){
            this.single=a;
            this.maxPath=b;
        }
    }

    private int max(int a,int b){
        return a>b?a:b;
    }

    private Result func(TreeNode node){
        if(node==null){
            return new Result(0,Integer.MIN_VALUE);
        }else {
            Result right = func(node.right);
            Result left = func(node.left);
            Result res = new Result();
            if(left.single>right.single)
                res.single=max(left.single+node.val,0);
            else
                res.single=max(right.single+node.val,0);
            int maxPath=max(left.maxPath,right.maxPath);
            res.maxPath=max(maxPath,left.single+right.single+node.val);
            return res;
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
