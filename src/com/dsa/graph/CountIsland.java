package com.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class CountIsland {

    public int bfs(int x, int y, int [][] grid, boolean[][] visited){
        int total =0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});
        visited[x][y]=true;
        while(!q.isEmpty()){
            int []n = q.poll();
            if(grid[n[0]][n[1]]  > 0){
                total += grid[n[0]][n[1]];
            }
            int [][] dis = {{-1,0}, {1, 0}, {0, 1}, {0, -1}};
            for(int i=0; i< 4; i++){
                int nx = n[0] + dis[i][0];
                int ny = n[1] + dis[i][1];
                boolean isValidMove = nx >=0 &&  ny >=0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] > 0 &&  !visited[nx][ny];
                if(isValidMove){
                    visited[nx][ny]=true;
                    q.offer(new int[] {nx,ny});
                }
            }
        }
        return total;
    }
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int cnt = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] > 0){
                    if(!visited[i][j]){
                        int total = bfs(i,j,grid,visited);
                        if(total > 0 && total % k ==0){
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {

    }
}
