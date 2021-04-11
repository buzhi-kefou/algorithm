package com.soulmate.practice;

public class P153 {

    public int findMin(int[] nums) {
        int l=0,r=nums.length-1,mid=(l+r)/2;
        char flag;
        while (true){
            flag=func(nums,nums[l],nums[mid],nums[r]);
            if(flag=='0')
                return nums[l];
            if(flag=='l')
                r=mid;
            else
                l=mid;
            mid=(l+r)/2;
            if(l==mid||r==mid)
                return nums[l]<nums[r]?nums[l]:nums[r];
        }
    }

    private char func(int[] nums,int a,int b,int c){
        if(a>c){
            if(a>b)
                return 'l';
            else
                return 'r';
        }else
            return '0';
    }

}
