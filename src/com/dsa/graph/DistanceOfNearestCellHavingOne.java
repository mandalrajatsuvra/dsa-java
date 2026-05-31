package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHavingOne {


    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int r =  grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int [][] dist = new int[r][c];
        for(int i=0; i<r; i++){
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 1){
                    dist[i][j] = 0;
                    queue.offer(new int[]{i,j, 0});
                    visited[i][j] = true;
                }
            }
        }
        int [][] dis = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int [] cur = queue.poll();
                int x =  cur[0];
                int y = cur[1];
                int d = cur[2];
                dist[x][y] = d;

                for(int k=0; k<4; k++){
                    int x1 =  x+dis[k][0];
                    int y1 =  y+dis[k][1];
                    boolean isValidMove = x1 >= 0  && y1 >= 0 && x1 < r && y1 < c && dist[x1][y1] == -1 && !visited[x1][y1];
                    if(isValidMove){
                        visited[x1][y1] = true;
                        queue.offer(new int[]{x1,y1,d+1});
                    }
                }
            }
        }
        for(int i=0; i<r; i++){
            ArrayList<Integer> eachRow = new ArrayList<>();
            for(int j=0; j<c; j++){
                eachRow.add(dist[i][j]);
            }
            res.add(eachRow);
        }
        return res;
    }

    public static void main(String[] args) {
        DistanceOfNearestCellHavingOne d = new DistanceOfNearestCellHavingOne();
        int[][] grid = new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 0, 0}
        };
        System.out.println( d.nearest(grid));
    }
}
