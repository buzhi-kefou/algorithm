package com.soulmate.practice;

public class P70 {

    public int climbStairs(int n) {
        int[] arr=new int[n];
        for(int i=1;i<=n;i++)
            func(i,arr);
        return arr[n-1];
    }

    private void func(int n,int[] arr){
        if(n==1||n==2)
            arr[n-1]=n;
        else
            arr[n-1]=arr[n-2]+arr[n-3];
    }

}
