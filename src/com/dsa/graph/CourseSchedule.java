package com.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> G = new ArrayList<>();
        for(int i=0; i<n; i++){
            G.add(new ArrayList<>());
        }
        for(int i=0; i<  prerequisites.length;i++){
            int u =  prerequisites[i][1];
            int v =  prerequisites[i][0];
            G.get(u).add(v);
        }
        int [] indegrees = new int[n];
        for(int i=0; i<prerequisites.length; i++){
            int u =  prerequisites[i][1];
            indegrees[u] += 1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int u = q.poll();
            ans.add(u);
            ArrayList<Integer> adjList =  G.get(u);
            for(int v: adjList){
                indegrees[v] --;
                if(indegrees[v] == 0){
                    q.add(v);
                }
            }
        }
        return ans.size() == n ? ans: new ArrayList<>();
    }


    public static void main(String[] args) {

    }
}
