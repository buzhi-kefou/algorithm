package com.soulmate.practice;

import java.util.Stack;

public class P394 {

    public String decodeString(String s) {
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        boolean flag=true;
        for (int i = 0; i < chars.length; i++) {
            if(flag&&Character.isDigit(chars[i])){
                flag=false;
            }else if(flag&&chars[i]!='['){
                builder.append(chars[i]);
                continue;
            }
            if(chars[i]!=']')
                stack.push(chars[i]);
            else {
                StringBuilder sub = new StringBuilder();
                char temp=stack.pop();

                while (temp!='['){
                    sub.append(temp);
                    temp=stack.pop();
                }
                String str = sub.reverse().toString();

                sub = new StringBuilder();
                temp=stack.pop();
                while (Character.isDigit(temp)){
                    sub.append(temp);
                    if(stack.isEmpty())
                        break;
                    temp=stack.pop();
                }
                if(!stack.isEmpty())
                    stack.push(temp);
                int num = Integer.parseInt(sub.reverse().toString());

                sub = new StringBuilder();
                while (num!=0){
                    sub.append(str);
                    num--;
                }
                str = sub.toString();

                if(stack.contains('[')){
                    int len = str.length();
                    for(int j=0;j<len;j++)
                        stack.push(str.charAt(j));
                }else{
                    builder.append(str);
                    flag=true;
                }
            }
        }
        StringBuilder last = new StringBuilder();
        while (!stack.isEmpty())
            last.append(stack.pop());
        if(last.length()!=0)
            builder.append(last.reverse().toString());
        return builder.toString();
    }

}
