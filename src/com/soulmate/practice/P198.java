package com.soulmate.practice;

import static java.lang.Math.max;

public class P198 {

    public int rob(int[] nums) {
        int size=nums.length;
        if(size==0)
            return 0;
        if(size==1)
            return nums[0];
        if(size==2)
            return max(nums[0],nums[1]);
        int temp;
        nums[1]=max(nums[0],nums[1]);
        for(int i=2;i<size;i++){
            temp=nums[i-1];
            nums[i]=max(temp,nums[i-2]+nums[i]);
            nums[i-1]=temp;
        }
        return nums[size-1];
    }

}
