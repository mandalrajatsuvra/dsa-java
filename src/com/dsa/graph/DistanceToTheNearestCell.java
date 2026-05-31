package com.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceToTheNearestCell {


    public int[][] nearest(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;
        int [][]res = new int[r][c];
        boolean[][] visited = new boolean[r][c];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i< r; i++){
            for(int j=0; j< c; j++){
                if(grid[i][j] ==1){
                    visited[i][j] = true;
                    res[i][j] = 0;
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }
        int dis[][] = {{-1,0}, {1, 0}, {0, -1}, {0,1}};
        while(!queue.isEmpty()){
            int node[] = queue.poll();
            int x = node[0];
            int y = node[1];
            int distance = node[2];
            res[x][y] = distance;
            for(int i=0; i< dis.length; i++){
                int dx = dis[i][0];
                int dy = dis[i][1];
                int x1 = x + dx;
                int y1 = x + dy;
                if(x1 >=0 && y1 >=0 && x1 < r && y1 < c && !visited[x1][y1] && grid[x1][y1] == 0){
                    visited[x1][y1] = true;
                    queue.offer(new int[]{x1, y1, distance+1});
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
