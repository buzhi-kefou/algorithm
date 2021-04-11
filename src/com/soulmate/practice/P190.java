package com.soulmate.practice;

import java.math.BigInteger;

public class P190 {

    public int reverseBits(int n) {
        char[] binary = Integer.toBinaryString(n).toCharArray();
        StringBuilder builder = new StringBuilder();
        int len=binary.length;

        for(int i=len-1;i>=0;i--)
            builder.append(binary[i]);

        if(len<32){
            len=32-len;
            while (len--!=0)
                builder.append('0');
        }

        BigInteger integer = new BigInteger(builder.toString(), 2);
        return integer.intValue();
    }

}
