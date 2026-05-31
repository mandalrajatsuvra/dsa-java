package com.dsa.graph;

import java.util.List;
//Correct solutions
public class FindSafeWalkThroughAGrid_3286 {


    public boolean dfs(int x, int y, boolean[][] visited, int health, List<List<Integer>> graph) {
        if(health <= 0){
             return false;
        }
        if(x == graph.size()-1 && y == graph.get(0).size()-1 && health >= 1){
            return true;
        }
        visited[x][y] = true;

        int [][] dis = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};

        for(int []d: dis){
            int x1 = x+d[0], y1 = y+d[1];
            boolean idValidMove = x1 >= 0 && y1 >= 0 && x1 < graph.size() && y1 < graph.get(0).size() && !visited[x1][y1];
            if(idValidMove){
                if(dfs(x1, y1, visited, health-graph.get(x1).get(y1), graph)) return true;
            }
        }
        return false;
    }


    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        if(health == 0){
            return false;
        }
        boolean [][] visited = new boolean[n][m];
        return dfs(0, 0, visited, health, grid);
    }

    public static void main(String[] args) {

    }
}
