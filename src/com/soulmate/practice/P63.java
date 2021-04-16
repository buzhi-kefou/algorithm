package com.soulmate.practice;

public class P63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int[][] arr=new int[m][n];
        boolean a,b;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==0){
                    a=i-1<0;
                    b=j-1<0;
                    if(a&&b){
                        arr[i][j]=1;
                        continue;
                    }
                    if(a){
                        arr[i][j]=arr[i][j-1];
                        continue;
                    }
                    if(b){
                        arr[i][j]=arr[i-1][j];
                        continue;
                    }
                    arr[i][j]=arr[i-1][j]+arr[i][j-1];
                } else
                    arr[i][j]=0;
            }
        }
        return arr[m-1][n-1];
    }

}
