package com.soulmate.practice;

public class P76 {

    boolean[] U=new boolean[26];
    boolean[] L=new boolean[26];

    public String minWindow(String s, String t) {
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        int[] upper=new int[26];
        int[] lower=new int[26];

        func(upper,lower,array2);

        int[] res=new int[2];
        int ptr1=0,ptr2=0,cnt=0;
        int[] countU=new int[26];
        int[] countL=new int[26];
        while(ptr2<array1.length){
            char ch=array1[ptr2];
            if(Character.isLowerCase(ch)){
                ch-='a';
                if(L[ch]){
                    if(++countL[ch]<=lower[ch])
                        cnt++;
                }
            }else {
                ch-='A';
                if(U[ch]){
                    if(++countU[ch]<=upper[ch])
                        cnt++;
                }
            }
            if(cnt==array2.length){
                while (ptr1<=ptr2){
                    char tmp=array1[ptr1];
                    if(Character.isLowerCase(tmp)&&L[tmp-'a']){
                        tmp-='a';
                        if(countL[tmp]==lower[tmp]){
                            test(ptr1,ptr2,res);
                            countL[tmp]-=1;
                            ptr1++;
                            cnt--;
                            break;
                        }
                        countL[tmp]-=1;
                    }else if(Character.isUpperCase(tmp)&&U[tmp-'A']){
                        tmp-='A';
                        if(countU[tmp]==upper[tmp]){
                            test(ptr1,ptr2,res);
                            countU[tmp]-=1;
                            ptr1++;
                            cnt--;
                            break;
                        }
                        countU[tmp]-=1;
                    }
                    ptr1++;
                }
            }
            ptr2++;
        }

        if(res[0]==res[1])
            return "";
        else
            return s.substring(res[0],res[1]);
    }

    private void func(int[] upper,int[] lower,char[] array){
        for (char ch : array) {
            if(Character.isLowerCase(ch)){
                lower[ch-'a']+=1;
                L[ch-'a']=true;
            } else{
                upper[ch-'A']+=1;
                U[ch-'A']=true;
            }
        }
    }

    private void test(int ptr1,int ptr2,int[] res){
        if(res[0]==res[1]||(res[1]-res[0]>ptr2-ptr1+1)){
            res[1]=ptr2+1;
            res[0]=ptr1;
        }
    }
}
