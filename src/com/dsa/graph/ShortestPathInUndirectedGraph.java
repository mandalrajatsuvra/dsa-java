package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class    ShortestPathInUndirectedGraph {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int [] distance= new int[adj.size()];
        Arrays.fill(distance, -1);
        distance[src] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        while (!queue.isEmpty()){
            int u = queue.poll();
            for(int v: adj.get(u)){
                int newDistance = distance[u] + 1;
                if(distance[v] == -1){
                    distance[v] = newDistance;
                    queue.offer(v);
                }
            }
        }
        return distance;
    }
    public static void main(String[] args) {

    }
}
