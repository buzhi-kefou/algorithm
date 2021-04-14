package com.soulmate.practice;

import java.util.Arrays;

public class P128 {

    public int longestConsecutive(int[] nums) {
        if (nums.length==0)
            return 0;
        Arrays.sort(nums);
        int curr=1,max=1;
        int len=nums.length-1;
        for(int i=0;i<len;i++){
            if(nums[i]==nums[i+1])
                continue;
            if(nums[i]+1==nums[i+1]){
                curr++;
            }else {
                if(curr>max)
                    max=curr;
                curr=1;
            }
        }
        return Math.max(max,curr);
    }

}
