package com.soulmate.practice;

public class P33 {

    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1,mid=(l+r)/2;
        char flag;
        while (true){
            flag=func(nums[l],nums[mid],nums[r],target);
            if(flag=='0'){
                if(target==nums[mid])
                    return mid;
                if (target==nums[l])
                    return l;
                else
                    return r;
            }
            if(flag=='l')
                r=mid-1;
            else
                l=mid+1;
            if(l>r)
                break;
            else
                mid=(l+r)/2;
        }
        return -1;
    }

    private char func(int a,int b,int c,int target){
        if(target==a||target==b||target==c)
            return '0';
        if(a>c){
            if(a>b){
                if(b>target)
                    return 'l';
                else
                if(c>target)
                    return 'r';
                return 'l';
            }else {
                if(b>target){
                    if(a>target)
                        return 'r';
                    return 'l';
                }else
                    return 'r';
            }
        }else {
            if(b>target)
                return 'l';
            else
                return 'r';
        }
    }

}
