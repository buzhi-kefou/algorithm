package com.soulmate.practice;

import java.util.LinkedList;
import java.util.List;

public class P93 {

    public List<String> restoreIpAddresses(String s) {
        if(s.length()>12)
            return null;
        func(1,s,new StringBuilder());
        return res;
    }

    List<String> res=new LinkedList<String>();

    private void func(int step,String str,StringBuilder builder){
        for(int i=1;i<=str.length()&&i<4;i++){
            String sub=str.substring(0,i);
            if(test(sub)){
                StringBuilder temp = new StringBuilder(builder);
                if(builder.length()!=0)
                    temp.append('.');
                temp.append(sub);
                if(step==4&&i==str.length()){
                    res.add(temp.toString());
                    return;
                }
                if(step<4)
                    func(step+1,str.substring(i),temp);
            }
        }
    }

    private boolean test(String str){
        if(str.length()>1&&str.charAt(0)=='0')
            return false;
        int parse = Integer.parseInt(str);
        if(parse>255)
            return false;
        else
            return true;
    }
}
