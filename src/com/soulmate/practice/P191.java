package com.soulmate.practice;

public class P191 {

    public int hammingWeight(int n) {
        int count=0;
        for(int i=0;i<32;i++){
            if((n&-2147483648)<0)
                count++;
            n<<=1;
        }
        return count;
    }

}
