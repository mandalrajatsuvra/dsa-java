package com.dsa.graph;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetonateTheMaximumBombs_2101 {

    public int bfs(int u, ArrayList<Integer>[] G){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[G.length];
        visited[u] = true;
        q.add(u);
        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            for(int v: G[node]){
                if(!visited[v]){
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
        return cnt;
    }

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        ArrayList<Integer> [] G = new ArrayList[n];
        for(int i=0; i<n; i++){
            G[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            int []p1 = bombs[i];
            for(int j=0; j<n; j++){
                if(i==j) continue;
                int [] p2 = bombs[j];

                BigInteger x1 = BigInteger.valueOf(p1[0]-p2[0]);
                BigInteger x2 = BigInteger.valueOf(p1[1]-p2[1]);
                x1 = x1.multiply(x1);
                x2 = x2.multiply(x2);
                BigInteger distance = x1.add(x2);
                BigInteger radius = BigInteger.valueOf(p1[2]).multiply(BigInteger.valueOf(p1[2]));
                if(distance.compareTo(radius) <= 0){
                    G[i].add(j);
                }
            }
        }
        int maxDetonation = 0;
        for(int u=0; u < n; u++){
            maxDetonation = Math.max(maxDetonation, bfs(u, G));
        }
        return maxDetonation;
    }

    public static void main(String[] args) {
        int [][] bombs =  new int[][]{
                {2,1,3},
                {6,1,4}
        };
        DetonateTheMaximumBombs_2101 de = new DetonateTheMaximumBombs_2101();
        System.out.println(de.maximumDetonation(bombs));

        int [][] bombs2 = new int[][]{
                {1,1,5},
                {10,10,5}
        };
        System.out.println(de.maximumDetonation(bombs2));

        int [][] bombs3  = new int[][]{
                {1,2,3},
                {2,3,1},
                {3,4,2},
                {4,5,3},
                {5,6,4}
        };
        System.out.println(de.maximumDetonation(bombs3));

    }

}
