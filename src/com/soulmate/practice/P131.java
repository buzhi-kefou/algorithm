package com.soulmate.practice;

import java.util.LinkedList;
import java.util.List;

public class P131 {

    List<List<String>> res= new LinkedList<>();

    public List<List<String>> partition(String s) {
        split(0,s,new LinkedList<>());
        return res;
    }

    private void split(int beg,String str,List<String> list){
        for(int ptr=str.length();ptr>beg;ptr--){
            if(test(str.substring(beg,ptr))){
                LinkedList<String> temp = new LinkedList<>(list);
                if(ptr!=str.length()){
                    temp.add(str.substring(beg,ptr));
                    split(0,str.substring(ptr),new LinkedList<>(temp));
                }else {
                    temp.add(str);
                    res.add(temp);
                }
            }
        }
    }

    private boolean test(String string){
        for(int i=0,j=string.length()-1;i<=j;i++,j--){
            if(string.charAt(i)!=string.charAt(j))
                return false;
        }
        return true;
    }
}
