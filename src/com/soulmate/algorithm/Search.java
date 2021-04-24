package com.soulmate.algorithm;

public class Search {

    public static int binarySearch(int[] arr,int val){
        int l=0,r=arr.length-1,mid=l+(r-l)/2;
        while (l<=r){
            if(arr[mid]==val)
                return arr[mid];
            if(arr[mid]>val)
                r--;
            else
                l++;
            mid=l+(r-l)/2;
        }
        return -1;
    }
}
