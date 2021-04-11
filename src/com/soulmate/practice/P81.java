package com.soulmate.practice;

import java.util.Arrays;

public class P81 {

    public boolean search(int[] nums, int target) {
        int l=0,r=nums.length-1,mid=(l+r)/2;
        char flag;
        while (true){
            flag=func(nums[l],nums[mid],nums[r],target);
            if(flag=='d'){
                int[] sub;
                boolean search=false;
                if(l+1<mid){
                    sub= Arrays.copyOfRange(nums,l+1,mid);
                    search= search(sub, target);
                }
                if(search)
                    return true;
                if(mid+1<r){
                    sub=Arrays.copyOfRange(nums,mid+1,r);
                    search = search(sub, target);
                }
                if(search)
                    return true;
                else
                    return false;
            }
            if(flag=='0')
                return true;
            if(flag=='l')
                r=mid-1;
            else
                l=mid+1;
            if(l>r)
                break;
            else
                mid=(l+r)/2;
        }
        return false;
    }

    private char func(int a,int b,int c,int target){
        if(target==a||target==b||target==c)
            return '0';
        if(a>=c){
            if(b>target){
                if(a>=b)
                    return 'l';
                return 'd';
            }else {
                if(a<b)
                    return 'r';
                else
                    return 'd';
            }
        }else {
            if(b<target)
                return 'r';
            else
                return 'l';
        }
    }

}