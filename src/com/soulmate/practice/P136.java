package com.soulmate.practice;

public class P136 {

    public int singleNumber(int[] nums) {
        int res=0;
        for (int num : nums) {
            res^=num;
        }
        return res;
    }

}
