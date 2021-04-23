package com.soulmate.practice;

public class P509 {

    public int fib(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;

        int i=0,j=1,k;
        while (n-->1){
            k=j;
            j+=i;
            i=k;
        }
        return j;
    }

}
