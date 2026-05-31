package com.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrerequisiteTasks {
    public boolean isPossible(int N, int P, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> G = new ArrayList<>();
        for(int i=0; i<N; i++){
            G.add(new ArrayList<>());
        }
        for(int i=0; i<P; i++){
            G.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int [] indegrees = new int[N];

        for(int i=0; i<P; i++){
            int v = prerequisites[i][0];
            indegrees[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<N; i++){
            if(indegrees[i] == 0){
                queue.add(i);
            }
        }
        int cnt = 0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            cnt += 1;
            ArrayList<Integer> adjList = G.get(u);
            for(int v: adjList){
                indegrees[v]--;
                if(indegrees[v] == 0){
                    queue.add(v);
                }
            }
        }
        return cnt == N;
    }

    public static void main(String[] args) {

    }
}
