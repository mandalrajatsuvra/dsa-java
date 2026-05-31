package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class FindTheStringInGrid {
    public boolean solve(char[][] board, int x, int y, boolean[][] visited, String word, int pos){
        if(pos==word.length()){
            return true;
        }
        visited[x][y]=true;
        int [][] dis = {{-1,0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for(int i=0;i<dis.length;i++){
            int x1 = x + dis[i][0];
            int y1 = y + dis[i][1];
            boolean isValidMove = x1 >=0 && y1 >= 0 &&  x1 < board.length && y1 < board[0].length && !visited[x1][y1] && board[x1][y1]==word.charAt(pos);
            if(isValidMove){
                if(solve(board,x1,y1,visited,word,pos+1)) return true;
            }
        }
        visited[x][y]=false;
        return false;
    }
    public int[][] searchWord(char[][] grid, String word) {
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==word.charAt(0)){
                    boolean [][] visited = new boolean[grid.length][grid[0].length];
                    if(solve(grid, i,j,visited,word,1)){
                        list.add(new int[] {i,j});
                    }
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {

    }
}
