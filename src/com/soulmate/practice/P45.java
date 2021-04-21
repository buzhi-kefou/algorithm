package com.soulmate.practice;

public class P45 {

    public int jump(int[] nums) {
        int len = nums.length;
        int maxPosition = 0, step = 0, end = 0;
        for (int i = 0; i < len - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

}
