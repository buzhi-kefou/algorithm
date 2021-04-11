package com.soulmate.practice;

public class P35 {

    public int searchInsert(int[] nums, int target) {
        int l=0,r=nums.length-1,mid=(l+r)/2;
        if(nums[l]>=target)
            return l;
        if (nums[r]<target)
            return ++r;
        int tmp=0;
        while (true){
            if(nums[mid]==target)
                return mid;
            else if (nums[mid]<target){
                l++;
                tmp=l;
            }
            else if (nums[mid]>target){
                tmp=r;
                r--;
            }
            if(l<=r)
                mid=(l+r)/2;
            else
                return tmp;
        }
    }

}
