package com.soulmate.practice;

import java.util.LinkedList;
import java.util.List;

public class P438 {

    public List<Integer> findAnagrams(String s, String p) {
        LinkedList<Integer> list = new LinkedList<>();
        char[] source = s.toCharArray();
        char[] dest = p.toCharArray();
        boolean[] exist=new boolean[26];
        int[] count=new int[26];

        for (char ch : dest)
            exist[ch-'a']=true;
        initial(count,dest);
        int ptr1=0,ptr2=0;

        while (ptr2<source.length){
            int ptr=source[ptr2]-'a';
            if(exist[ptr]){
                if(count[ptr]==0){
                    for(int i=ptr1;i<ptr2;i++){
                        if(source[i]==source[ptr2]){
                            ptr1=i+1;
                            break;
                        }
                        count[source[i]-'a']+=1;
                    }
                }else
                    count[ptr]-=1;
            }else {
                ptr1=ptr2+1;
                initial(count,dest);
            }
            ptr2++;
            if(ptr2-ptr1==dest.length){
                count[source[ptr1]-'a']+=1;
                list.add(ptr1++);
            }
        }
        return list;
    }

    private void initial(int[] map,char[] array){
        for(int i=0;i<map.length;i++)
            map[i]=0;
        for (char ch : array)
            map[ch-'a']+=1;
    }

}
