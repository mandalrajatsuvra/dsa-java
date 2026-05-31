package com.dsa.heap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public static class Node{
        public int x;
        public int y;
        public int distance;
        public String path;
        public Node(int x, int y, int distance, String path){
            this.x = x;
            this.y =y;
            this.distance= distance;
            this.path = path;
        }
    }
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int r = maze.length;
        int c = maze[0].length;
        Queue<Node> queue = new LinkedList<>();
        PriorityQueue<String> minHeap = new PriorityQueue<>();
        Node source = new Node(ball[0], ball[1], 0, "");
        int [][]distance = new int[r][c];
        for(int [] d: distance){
            Arrays.fill(d, -1);
        }
        distance[ball[0]][ball[1]] = 0;
        queue.add(source);
        while (!queue.isEmpty()){
            Node u = queue.poll();
            if(u.x == hole[0] && u.y == hole[1]){
                minHeap.add(u.path);
            }
            int [][]dis = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
            char [] dir = {'u','d','l','r'};
            for(int i=0; i< dis.length; i++){
                int x1 = u.x + dis[i][0];
                int y1 = u.y + dis[i][1];
                boolean isValid = x1 >= 0 && x1 < r && y1 >= 0 && y1 < c && maze[x1][y1] == 0;
                if(isValid){
                    int newDistance = 1 + distance[u.x][u.y];
                    if(distance[x1][y1] == -1){
                        distance[x1][y1] = newDistance;
                        String newPath ="";
                        if(u.path.isEmpty()){
                            newPath = u.path  + dir[i];
                        }else if(u.path.charAt(u.path.length()-1) != dir[i]){
                            newPath = u.path  + dir[i];
                        }else{
                            newPath = u.path;
                        }
                        Node node = new Node(x1, y1, newDistance, newPath);
                        queue.add(node);
                    }else if(newDistance <= distance[x1][y1]){
                        distance[x1][y1] = newDistance;
                        String newPath ="";
                        if(u.path.isEmpty()){
                            newPath = u.path  + dir[i];
                        }else if(u.path.charAt(u.path.length()-1) != dir[i]){
                            newPath = u.path  + dir[i];
                        }else{
                            newPath = u.path;
                        }
                        Node node = new Node(x1, y1, newDistance, newPath);
                        queue.add(node);
                    }
                }
            }
        }
        if(!minHeap.isEmpty()){
            return minHeap.poll();
        }
        return "impossible";
    }
}


public class TheMazeIII {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [][]maze = {
                {0,0,0,0,0},
                {1,1,0,0,1},
                {0,0,0,0,0},
                {0,1,0,0,1},
                {0,1,0,0,0}
        };
        int [] ball = {4, 3};
        int []hole = {0,1};
        System.out.println(s.findShortestWay(maze, ball, hole));
    }
}
