package com.dsa.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostPathGFG {

    // Correct solution but TLE
    public int dfs(int x, int y, int r, int c, boolean[][] visited, int [][]grid, int [][] dp){
        if(x == r-1 && y == c-1){
            return grid[x][y];
        }
        visited[x][y] = true;
        int [][] dis = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
        int minCost = (int)(1e9);
        for(int [] d : dis){
            int x1 = x + d[0];
            int y1 = y + d[1];
            boolean isValidMove = x1 >= 0 && x1 < r && y1 >= 0 && y1 < c && !visited[x1][y1];
            if(isValidMove){
                minCost = Math.min(minCost, grid[x][y] + dfs(x1, y1, r, c, visited, grid, dp));
            }
        }
        visited[x][y] = false;
        return dp[x][y] = minCost;
    }


    public int minimumCostPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] distances = new int[n][m];
        for(int [] d: distances){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        distances[0][0] = grid[0][0];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        queue.offer(new int[]{0,0, distances[0][0]});
        while(!queue.isEmpty()){
            int []node  = queue.poll();
            int x = node[0], y = node[1];
            int cost  = node[2];
            int [][] dis = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};

            for(int [] d : dis){
                int x1 = x + d[0];
                int y1 = y + d[1];
                boolean isValidMove = x1 >= 0 && x1 < n && y1 >= 0 && y1 < m;
                if(isValidMove){
                    if(distances[x1][y1] > cost + grid[x1][y1]){
                        distances[x1][y1] = cost + grid[x1][y1];
                        queue.offer(new int[]{x1, y1, distances[x1][y1]});
                    }
                }
            }
        }
        return distances[n-1][m-1];
    }

    public static void main(String[] args) {
        int [][] grid = new int[][]{
                {9,4,9,9},
                {6,7,6,4},
                {8,3,3,7},
                {7,4,9,10}
        };
        MinimumCostPathGFG obj = new MinimumCostPathGFG();
        System.out.println(obj.minimumCostPath(grid));

        int [][] grid2 = new int[][]{
                {4,4},
                {3,7}
        };
        System.out.println(obj.minimumCostPath(grid2));
    }
}
