package com.soulmate.practice;

public class P64 {

    int row,col;
    int[][]  temp;
    public int minPathSum(int[][] grid) {
        row=grid.length-1;
        col=grid[0].length-1;
        temp=new int[row][col];
        return func(grid,0,0,temp);
    }

    private int func(int[][] ints,int x,int y,int[][] temp){
        if(x==row&&y==col)
            return ints[x][y];
        if(temp[x][y]!=0)
            return temp[x][y];
        int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE;
        if(x+1<=row)
            a=func(ints,x+1,y,temp);
        if(y+1<=col)
            b=func(ints,x,y+1,temp);
        return temp[x][y]=Math.min(a,b)+ints[x][y];
    }

}
