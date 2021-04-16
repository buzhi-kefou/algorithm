package com.soulmate.practice;

public class P62 {

    public int uniquePaths(int m, int n) {
        int[][] arr=new int[m][n];
        arr[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                func(arr,i,j);
        }
        return arr[m-1][n-1];
    }

    private int func(int[][] arr,int x,int y){
        if(x<0||y<0)
            return 0;
        if(arr[x][y]!=0)
            return arr[x][y];
        return arr[x][y]=func(arr,x-1,y)+func(arr,x,y-1);
    }

}
