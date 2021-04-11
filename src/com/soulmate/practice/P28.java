package com.soulmate.practice;

public class P28 {

    public int strStr(String haystack, String needle) {
        int res=-1;
        if(haystack.length()==0&&needle.length()==0)
            return 0;
        for(int i=0;res==-1&&i<haystack.length();i++){
            if(i+needle.length()>haystack.length())
                break;
            if(haystack.substring(i,i+needle.length()).equals(needle))
                res=i;
        }
        return res;
    }

}
