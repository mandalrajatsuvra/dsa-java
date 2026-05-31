package com.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {


    public int orangesRotting(int[][] mat) {

        int r = mat.length;
        int c = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i< r; i++){
            for(int j=0; j< c; j++){
                if(mat[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int time = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            boolean isRottenSomeOrange = false;
            for(int i=0; i< size; i++){
                int [] node = queue.poll();
                int [][]dis = {{-1, 0}, {1, 0}, {0,1}, {0, -1}};
                for(int j=0; j< dis.length; j++) {
                    int dx = dis[i][0];
                    int dy = dis[i][1];
                    int x1 = node[0] + dx;
                    int y1 = node[1] + dy;
                    boolean isValid = x1 >= 0 && x1 < r && y1 >= 0 && y1 < c && mat[x1][y1] == 1;
                    if (isValid) {
                        mat[x1][y1] = 2;
                        isRottenSomeOrange = true;
                        queue.offer(new int[]{x1, y1});
                    }
                }
            }
            if(isRottenSomeOrange){
                time++;
            }
        }
        for(int i=0; i< r; i++){
            for(int j=0; j< c; j++){
                if(mat[i][j] ==1) return -1;
            }
        }
        return time;
    }


    public static void main(String[] args) {

    }
}
