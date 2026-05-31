package com.dsa.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoSortIterative {


    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<Integer> G[] = new LinkedList[V];
        for(int i=0; i < V; i++){
            G[i] = new LinkedList<>();
        }
        int [] indegrees = new int[V];
        for(int i=0; i< edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            indegrees[v]++;
            G[u].add(v);
        }
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i< V; i++){
            if(indegrees[i] ==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int u = queue.poll();
            res.add(u);
            for(int v: G[u]){
                if(--indegrees[v] ==0){
                    queue.add(v);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [][] edges = {{3,0}, {1, 0}, {2, 0}};
        System.out.println(topoSort(4, edges));
    }
}
