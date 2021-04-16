package com.soulmate.practice;

import static java.lang.Math.max;

public class P55 {

    public boolean canJump(int[] nums) {
        int destination=nums.length-1,reach=0;
        for(int i=0;i<destination;i++){
            reach=max(reach,i+nums[i]);
            if(reach>=destination)
                return true;
            if(reach<i)
                return false;
        }

        return true;
    }

}
