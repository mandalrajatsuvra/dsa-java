package com.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelsOfNodesGFG {

    // Correct solutions
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {

        boolean[] visited = new boolean[V];
        visited[0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int []node = queue.poll();

            if(node[0] == X) {
                return node[1];
            }

            for(int v:  adj.get(node[0])){
                if(!visited[v]){
                    visited[v] = true;
                    queue.offer(new int[]{v, node[1]+1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
