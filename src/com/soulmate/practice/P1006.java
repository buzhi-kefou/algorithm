package com.soulmate.practice;

import java.util.LinkedList;

public class P1006 {

    public static void main(String[] args) {
        System.out.println(new P1006().clumsy(10));
    }

    public int clumsy(int N) {
        LinkedList<Character> operate = new LinkedList<>();
        LinkedList<Integer> num = new LinkedList<>();
        num.addLast(N);
        int iterate=0,val;
        while(--N>0){
            switch (iterate){
                case 0:
                    val=num.pollLast()*N;
                    num.addLast(val);
                    break;
                case 1:
                    val=num.pollLast()/N;
                    num.addLast(val);
                    break;
                case 2:
                    operate.addLast('+');
                    num.addLast(N);
                    break;
                case 3:
                    operate.addLast('-');
                    num.addLast(N);
                    break;
            }
            iterate=(++iterate)%4;
        }
        while(!operate.isEmpty()){
            if (operate.pollFirst()=='+')
                val=num.pollFirst()+num.pollFirst();
            else
                val=num.pollFirst()-num.pollFirst();
            num.addFirst(val);
        }
        return num.pollFirst();
    }

}
