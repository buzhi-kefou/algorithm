package com.soulmate.practice;

public class P200 {

    int row;
    int col;

    public int numIslands(char[][] grid) {
        int cnt = 0;
        row = grid.length;
        col = grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    func(grid,i,j);
                }
            }
        }
        return cnt;
    }

    private void func(char[][] chars,int x,int y){
        if(x>=row||y>=col||x<0||y<0)
            return;
        if(chars[x][y]=='1'){
            chars[x][y]='0';
            func(chars,x,y+1);
            func(chars,x+1,y);
            func(chars,x,y-1);
            func(chars,x-1,y);
        }
    }

}
