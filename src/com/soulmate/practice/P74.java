package com.soulmate.practice;

public class P74 {

    int row,col,cmp;
    boolean flag=false;

    public boolean searchMatrix(int[][] matrix, int target) {
        cmp=target;
        row=matrix.length;
        col=matrix[0].length;

        func(matrix,0,row-1,true);

        return flag;
    }

    private void func(int[][] matrix,int min,int max,boolean tmp){
        if(min>max)
            return;
        boolean l,r;
        int pos=(min+max)/2;
        if(tmp){
            l=cmp<=matrix[pos][col-1];r=cmp>=matrix[pos][0];
            if(l&&r){
                row=pos;
                tmp=false;
                func(matrix,0,col-1,tmp);
                return;
            }
            if(!l){
                func(matrix,min+1,max,tmp);
                return;
            }
            if(!r){
                func(matrix,min,max-1,tmp);
            }
        }else {
            l=cmp<matrix[row][pos];
            r=cmp>matrix[row][pos];
            if(l){
                func(matrix,min,max-1,tmp);
                return;
            }
            if(r){
                func(matrix,min+1,max,tmp);
                return;
            }
            flag=true;
        }
    }

}
