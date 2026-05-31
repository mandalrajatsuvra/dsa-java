package com.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMazeGFG {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{source[0], source[1], 0});
        visited[source[0]][source[1]] = true;
        while (!queue.isEmpty()) {
            int node[] = queue.poll();
            if (node[0] == destination[0] && node[1] == destination[1]) {
                return node[2];
            }
            int [][]dis = {{-1,0}, {1,0}, {0,-1}, {0,1}};
            for (int i = 0; i < 4; i++) {
                int x = node[0] + dis[i][0];
                int y = node[1] + dis[i][1];
                boolean isValidMove = x >=0 &&  x < r && y >=0 && y < c && grid[x][y] == 1 && !visited[x][y];
                if (isValidMove) {
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y, node[2]+1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
