package com.soulmate.practice;

public class P338 {

    public int[] countBits(int num) {
        int highBit = 0;
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0)
                highBit = i;
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }
}
