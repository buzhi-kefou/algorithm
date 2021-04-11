package com.soulmate.practice;

import java.util.Stack;

public class P150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int len=tokens.length;
        for (int i = 0; i < len; i++) {
            if(!Character.isDigit(tokens[i].charAt(0))&&tokens[i].length()==1){
                int a=stack.pop(),b=stack.pop();
                switch (tokens[i]){
                    case "+":
                        stack.push(b+a);
                        break;
                    case "-":
                        stack.push(b-a);
                        break;
                    case "*":
                        stack.push(b*a);
                        break;
                    case "/":
                        stack.push(b/a);
                        break;
                }
            }else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

}
