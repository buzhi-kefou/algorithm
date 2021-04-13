package com.soulmate.practice;

import java.util.List;

public class P120 {

    int size;
    int[][] hash;
    public int minimumTotal(List<List<Integer>> triangle) {
        size=triangle.size();
        hash=new int[size][];
        return func(triangle,0,0);
    }

    private int func(List<List<Integer>> list,int pos,int row){
        if(row==size)
            return 0;
        if(hash[row]==null){
            hash[row]=new int[list.get(row).size()];
            for(int i=0;i<hash[row].length;i++)
                hash[row][i]=Integer.MIN_VALUE;
        }
        if(hash[row][pos]!=Integer.MIN_VALUE)
            return hash[row][pos];
        int a=func(list,pos,row+1);
        int b=func(list,pos+1,row+1);
        return hash[row][pos]=Math.min(a,b)+list.get(row).get(pos);
    }

}
