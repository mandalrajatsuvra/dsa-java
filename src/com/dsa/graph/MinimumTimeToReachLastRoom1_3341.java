package com.dsa.graph;

import java.util.Arrays;
import java.util.PriorityQueue;
// Correct solutions
public class MinimumTimeToReachLastRoom1_3341 {
    class Node{
        int x;
        int y;
        int currentTime;
        int timeToWait;
        public Node(int x, int y, int timeToWait, int currentTime) {
            this.x = x;
            this.y = y;
            this.currentTime = currentTime;
            this.timeToWait = Math.max(timeToWait, 0);
        }
    }

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int [][] res = new int[n][m];
        for(int [] d: res){
            Arrays.fill(d,Integer.MAX_VALUE);
        }
        res[0][0] = 0;
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b)-> a.timeToWait - b.timeToWait);
        minHeap.add(new Node(0,0,0,0));
        while(!minHeap.isEmpty()){
            Node node = minHeap.poll();
            int [][] dis = {{-1,0}, {1, 0}, {0,1}, {0,-1}};

            for(int [] d: dis){
                int x = node.x + d[0];
                int y = node.y + d[1];
                boolean isValidMove = x >= 0 &&  y >= 0 && x < n && y < m;
                if(isValidMove){
                    int waitTime =  Math.max(moveTime[x][y] - node.currentTime, 0);
                    if(res[x][y]  > node.currentTime + waitTime + 1){
                        res[x][y] = node.currentTime + waitTime + 1;
                        minHeap.add(new Node(x,y,waitTime,res[x][y]));
                    }
                }
            }
        }
        return res[n-1][m-1];
    }

    public static void main(String[] args) {
        MinimumTimeToReachLastRoom1_3341 m = new MinimumTimeToReachLastRoom1_3341();
        int [][] moveTime = {
                {0,4}, {4,4}
        };

        System.out.println(m.minTimeToReach(moveTime));
        int [][] moveTime2 = {
                {0,0,0},
                {0,0,0}
        };
        System.out.println(m.minTimeToReach(moveTime2));
        int [][] moveTime3 = {
                {0,1},
                {1,2}
        };
        System.out.println(m.minTimeToReach(moveTime3));
        int [][] moveTime4 = {
                {0, 2, 5},
                {1, 2, 6},
                {7, 3, 4}
        };
        System.out.println(m.minTimeToReach(moveTime4));
    }
}
