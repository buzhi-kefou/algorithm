package com.soulmate.practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class P17 {

    HashMap<Character,List<Character>> hashMap=new HashMap<>();

    List<String> res= new LinkedList<>();

    private void put(char key,String str){
        LinkedList<Character> list = new LinkedList<>();
        for(int i=0;i<str.length();i++)
            list.add(str.charAt(i));
        hashMap.put(key,list);
    }

    public List<String> letterCombinations(String digits) {
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
        for(int i=0;i<digits.length();i++)
            func(digits.charAt(i));
        for (StringBuilder builder : builders)
            res.add(builder.toString());
        return res;
    }

    List<StringBuilder> builders=new LinkedList<>();

    private void func(char key){
        List<Character> list = hashMap.get(key);
        if(builders.isEmpty()){
            for (Character character : list) {
                StringBuilder builder = new StringBuilder();
                builder.append(character);
                builders.add(builder);
            }
        }else {
            LinkedList<StringBuilder> exchange = new LinkedList<>();
            for (Character character : list) {
                for (StringBuilder builder : builders) {
                    StringBuilder temp= new StringBuilder(builder);
                    temp.append(character);
                    exchange.add(temp);
                }
            }
            builders=exchange;
        }
    }

}
