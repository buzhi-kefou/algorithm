package com.soulmate.practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class P47 {

    Set<List<Integer>> sets= new HashSet<>();

    List<List<Integer>> lists= new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] temp=new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            LinkedList<Integer> list = new LinkedList<>();
            list.add(nums[i]);
            temp[i]=true;
            func(nums,temp,list);
            temp[i]=false;
        }
        lists.addAll(sets);
        return lists;
    }

    private void func(int[] arr,boolean[] temp,List<Integer> list){
        if(list.size()==arr.length){
            sets.add(list);
        }else {
            for(int i=0;i<arr.length;i++){
                if(!temp[i]){
                    LinkedList<Integer> tmp = new LinkedList<>(list);
                    tmp.add(arr[i]);
                    temp[i]=true;
                    func(arr,temp,tmp);
                    temp[i]=false;
                }
            }
        }
    }

}
