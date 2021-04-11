package com.soulmate.practice;

public class P260 {

    public int[] singleNumber(int[] nums) {
        int mix=0;
        for (int num : nums) {
            mix^=num;
        }
        int div=1;
        while ((div&mix)==0){
            div<<=1;
        }
        int a=0,b=0;
        for (int num : nums) {
            if((div&num)==0){
                a^=num;
            }else {
                b^=num;
            }
        }

        return new int[]{a,b};
    }

}