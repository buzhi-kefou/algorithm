package com.soulmate.practice;

import java.util.LinkedList;
import java.util.List;

public class P95 {

    public List<TreeNode> generateTrees(int n) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        boolean[] array=new boolean[n+1];

        for(int i=1;i<=n;i++){
            array[i]=true;
            List<TreeNode> left = func(1,i,array);
            List<TreeNode> right = func(i+1,array.length,array);
            insert(i,nodes,left,right);
            array[i]=false;
        }
        return nodes;
    }

    private List<TreeNode> func(int beg,int stop,boolean[] array){
        LinkedList<TreeNode> list = new LinkedList<>();
        int i=beg;
        while (i<stop){
            if(!array[i]){
                array[i]=true;
                List<TreeNode> left = func(beg,i,array);
                List<TreeNode> right = func(i+1, stop, array);
                insert(i,list,left,right);
                array[i]=false;
            }
            i++;
        }
        return list;
    }

    private void insert(int val,List<TreeNode> list,List<TreeNode> left,List<TreeNode> right){
        boolean a=left.isEmpty(),b=right.isEmpty();
        if(a&&b){
            list.add(new TreeNode(val));
        }else {
            if(!a&&!b){
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode temp = new TreeNode(val);
                        temp.left=l;
                        temp.right=r;
                        list.add(temp);
                    }
                }
            }else {
                if(a){
                    for (TreeNode node : right) {
                        TreeNode temp = new TreeNode(val);
                        temp.right=node;
                        list.add(temp);
                    }
                }else {
                    for (TreeNode node : left) {
                        TreeNode temp = new TreeNode(val);
                        temp.left=node;
                        list.add(temp);
                    }
                }
            }
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
