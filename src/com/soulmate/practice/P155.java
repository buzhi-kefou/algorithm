package com.soulmate.practice;

import java.util.LinkedList;

public class P155 {

    class MinStack {

        private LinkedList<Integer> stack;

        private LinkedList<Integer> min;

        /** initialize your data structure here. */
        public MinStack() {
            stack=new LinkedList<>();
            min=new LinkedList<>();
        }

        public void push(int val) {
            stack.add(val);
            if(min.isEmpty()){
                min.add(val);
            }else {
                min.add(val<min.getLast()?val:min.getLast());
            }
        }

        public void pop() {
            stack.removeLast();
            min.removeLast();
        }

        public int top() {
            return stack.getLast();
        }

        public int getMin() {
            return min.getLast();
        }
    }

}
