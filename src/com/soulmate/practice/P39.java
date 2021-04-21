package com.soulmate.practice;

import java.util.*;

public class P39 {

    int destination;

    List<List<Integer>> lists= new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        destination=target;
        Arrays.sort(candidates);
        func(candidates,0,0,new LinkedList<>());
        return lists;
    }

    private void func(int[] arr,int pos,int sum,List<Integer> list){
        if(sum==destination){
            lists.add(list);
            return;
        }
        for(int i=pos;i<arr.length;i++){
            if(sum+arr[i]>destination)
                break;
            List<Integer> temp = new LinkedList<>(list);
            temp.add(arr[i]);
            func(arr,i,sum+arr[i],temp);
        }
    }

}
