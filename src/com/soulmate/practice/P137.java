package com.soulmate.practice;

public class P137 {

    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<32;i++){
            int sum=0;
            for(int j=0;j<nums.length;j++){
                sum+=(nums[j]>>i)&1;
            }
            sum%=3;
            if(sum!=0){
                result|=((sum%3)<<i);
            }
        }
        return result;
    }

}
