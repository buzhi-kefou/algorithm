package com.soulmate.practice;

public class P567 {

    public boolean checkInclusion(String s1, String s2) {
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        boolean[] exist=new boolean[26];
        int[] count=new int[26];
        for (char ch : array1) {
            ch-='a';
            count[ch]+=1;
            exist[ch]=true;
        }

        int ptr1=0,ptr2=0,cnt=array1.length;
        while (cnt!=0&&ptr2<array2.length){
            int pos=array2[ptr2]-'a';
            if(exist[pos]&&count[pos]!=0){
                if(cnt==array1.length)
                    ptr1=ptr2;
                count[pos]-=1;
                cnt--;
            }else {
                if(exist[pos]){
                    while (array2[ptr1]!=array2[ptr2]){
                        count[array2[ptr1++]-'a']+=1;
                        cnt++;
                    }
                    ptr1++;
                }else if (cnt!=array1.length){
                    cnt=array1.length;
                    while (ptr1<ptr2){
                        count[array2[ptr1++]-'a']+=1;
                    }
                }
            }
            ptr2++;
        }
        return cnt==0?true:false;
    }

}
