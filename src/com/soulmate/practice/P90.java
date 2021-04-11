package com.soulmate.practice;

import java.util.*;

public class P90 {

    List<List<Integer>> res=new LinkedList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res.add(new LinkedList<>());
        List<Integer> list;
        Arrays.sort(nums);
        int cmp=nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(i!=0){
                if(nums[i]!=cmp)
                    cmp=nums[i];
                else
                    continue;
            }
            list = new LinkedList<>();
            list.add(nums[i]);
            func(nums,i,list);
        }
        return res;
    }

    private void func(int[] nums,int pos,List<Integer> list){
        res.add(list);
        if(++pos>=nums.length)
            return;
        int cmp=nums[pos];
        for(int i=pos;i<nums.length;i++){
            if(i!=pos){
                if(nums[i]!=cmp)
                    cmp=nums[i];
                else
                    continue;
            }
            List<Integer> temp=new LinkedList<>(list);
            temp.add(nums[i]);
            func(nums,i,temp);
        }
    }

}