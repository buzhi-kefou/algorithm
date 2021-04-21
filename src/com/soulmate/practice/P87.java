package com.soulmate.practice;

import java.util.*;

public class P87 {

    public boolean isScramble(String s1, String s2) {
        Set<String> set = func(s1);
        return set.contains(s2);
    }

    private Set<String> func(String str){
        Set<String> set = new LinkedHashSet<>();
        int len=str.length();
        set.add(str);

        for(int i=1;i<len;i++){
            String sub1=str.substring(0,i);
            String sub2=str.substring(i,len);
            Set<String> func1 = func(sub1);
            Set<String> func2 = func(sub2);
            Set<String> subs = concat(func1, func2);
            set.addAll(subs);
        }

        return set;
    }

    private Set<String> concat(Set<String> sub1, Set<String> sub2){
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (String s1 : sub1) {
            for (String s2 : sub2) {
                set.add(s1.concat(s2));
                set.add(s2.concat(s1));
            }
        }
        return set;
    }

}
