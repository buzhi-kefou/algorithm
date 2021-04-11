package com.soulmate.practice;

public class P154 {

    public int findMin(int[] nums) {
        int l=0,r=nums.length-1,mid=(l+r)/2;
        char flag;
        while (true){
            if(l==mid||r==mid)
                return Math.min(nums[l],nums[r]);
            flag=func(nums,l,mid,r);
            if(flag=='0')
                return nums[l];
            if(flag=='l')
                r=mid;
            else
                l=mid;
            mid=(l+r)/2;
        }
    }

    private char func(int[] nums,int a,int b,int c){
        if(nums[a]>=nums[c]){
            if(nums[a]>nums[b])
                return 'l';
            if(nums[a]<nums[b])
                return 'r';
            if(nums[c]!=nums[b])
                return 'r';

            boolean fuck = fuck(nums, a, b);
            if(fuck)
                return 'r';
            else
                return 'l';
        }
        return '0';
    }

    private boolean fuck(int[] nums,int l,int r){
        for(int i=l+1;i<=r;i++)
            if(nums[i]!=nums[l])
                return false;
        return true;
    }

}
