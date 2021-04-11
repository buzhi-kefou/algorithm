package com.soulmate.practice;

public class P704 {

    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1,mid=(l+r)/2;
        if(target<nums[l]||target>nums[r])
            return -1;
        while (l<=r){
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                l++;
            else if(nums[mid]>target)
                r--;
            mid=(l+r)/2;
        }
        return -1;
    }

}
