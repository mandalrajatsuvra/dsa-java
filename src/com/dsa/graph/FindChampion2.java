package com.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindChampion2 {

    public int findChampion(int n, int[][] edges) {
        int [] indegrees = new int[n];
        ArrayList<Integer>[] G = new ArrayList[n];
        for(int i = 0; i < n; i++){
            G[i] = new ArrayList<>();
        }
        for(int []edge: edges){
            int u = edge[0];
            int v = edge[1];
            indegrees[v]++;
            G[u].add(v);
        }
        Queue<Integer> queue = new LinkedList<>();
        int node = -1;
        for(int i=0; i<n; i++){
            if(indegrees[i] == 0){
                queue.add(i);
                node = i;
            }
        }
        if(queue.size() > 1){
            return -1;
        }
        int cnt =0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            cnt++;
            for(int v: G[u]){
                if(--indegrees[v] == 0){
                    queue.add(v);
                }
            }
        }
        return cnt == n ? node: -1;
    }
}
