package com.dsa.recursion;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFillAlgorithms {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       int r = image.length;
       int c = image[0].length;
       int oldColor = image[sr][sc];
       Queue<int[]> queue = new LinkedList<>();
       int [] source = new int[]{sr, sc};
       image[sr][sc] = newColor;
       queue.offer(source);
       while (!queue.isEmpty()){
           int []node = queue.poll();
           int [][] directions = {{0,-1}, {0, 1}, {1, 0}, {-1,0}};
           for(int i=0; i< directions.length; i++){
               int dx = directions[i][0];
               int dy = directions[i][1];
               int x1 = node[0] + dx ;
               int y1 = node[0] + dy;
               boolean isValidMove = x1 >=0 && x1 < r && y1>=0 && y1 < c && image[x1][y1] == oldColor;
               if(isValidMove){
                   image[x1][y1] = newColor;
                   int [] newSource = new int[]{x1, y1};
                   queue.offer(newSource);
               }
           }
       }
       return image;
    }
}
