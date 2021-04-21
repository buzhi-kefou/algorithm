package com.soulmate.practice;

import java.util.LinkedList;
import java.util.List;

public class P46 {

    LinkedList<List<Integer>> lists = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] temp=new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            LinkedList<Integer> list = new LinkedList<>();
            list.add(nums[i]);
            temp[i]=true;
            func(nums,temp,list);
            temp[i]=false;
        }
        return lists;
    }

    private void func(int[] arr, boolean[] temp, List<Integer> set){
        if(set.size()==arr.length){
            lists.add(new LinkedList<>(set));
        }else {
            for(int i=0;i<arr.length;i++){
                if(!temp[i]){
                    LinkedList<Integer> list = new LinkedList<>(set);
                    list.add(arr[i]);
                    temp[i]=true;
                    func(arr,temp,list);
                    temp[i]=false;
                }
            }
        }
    }

}
