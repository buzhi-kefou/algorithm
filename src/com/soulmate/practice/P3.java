package com.soulmate.practice;

import java.util.HashSet;

public class P3 {

    public int lengthOfLongestSubstring(String s) {
        int ptr1=0,ptr2=0,max=0;
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        while (ptr2<chars.length){
            if(!set.add(chars[ptr2])) {
                if (max < set.size())
                    max = set.size();
                while (ptr1 < ptr2 && chars[ptr1] != chars[ptr2])
                    set.remove(chars[ptr1++]);
                ptr1++;
            }
            ptr2++;
        }
        return Math.max(max,set.size());
    }

}
