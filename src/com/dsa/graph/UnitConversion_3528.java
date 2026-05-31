package com.dsa.graph;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class UnitConversion_3528 {
    public int MOD = (int)1e9+7;
    public int[] baseUnitConversions(int[][] conversions) {
        int n  = conversions.length+1;
        ArrayList<int[]>[] G = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            G[i] = new ArrayList<>();
        }
        for (int i = 0; i < conversions.length; i++) {
            int u = conversions[i][0];
            int v = conversions[i][1];
            int w = conversions[i][2];
            G[u].add(new int[]{v,w});
        }

        int [] distance =  new int[n];
        Arrays.fill(distance, -1);
        distance[0] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,1});
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while (!q.isEmpty()) {
            int [] node = q.poll();
            int u = node[0];
            for(int []edge: G[u]) {
                int v = edge[0];
                int w = edge[1];
                if(!visited[v]) {
                    visited[v] = true;
                    BigInteger n1 = new BigInteger(String.valueOf(distance[u]));
                    BigInteger n2 = new BigInteger(String.valueOf(w));
                    distance[v] = n1.multiply(n2).mod(BigInteger.valueOf(MOD)).intValue();
                   // distance[v] = (distance[u] * w) % MOD;
                    q.add(new int[]{v, distance[v]});
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {

    }
}
