package com.soulmate.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P78 {

    int[] arr;
    LinkedList<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        arr=nums;
        res.add(new LinkedList<>());
        for(int i=1;i<=arr.length;i++){
            for(int j=0;j<arr.length;j++){
                LinkedList<Integer> list = new LinkedList<>();
                func(list,j,i);
            }
        }
        return res;
    }

    private void func(List<Integer> tmp,int ptr,int max){
        tmp.add(arr[ptr]);
        if (tmp.size() < max) {
            for (int i = ptr + 1; i < arr.length; i++)
                func(new LinkedList<>(tmp), i, max);
        } else {
            res.add(tmp);
        }
    }

}
