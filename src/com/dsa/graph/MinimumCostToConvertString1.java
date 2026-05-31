package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostToConvertString1 {

    public class Edge{
        int node;
        long cost;

        public Edge(int node, long cost){
            this.node = node;
            this.cost = cost;
        }

    }
    public long[] shortestPath(int source, ArrayList<Edge> G[] ) {
        long [] distance = new long[26];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2)->  {
            if(e1.cost == e2.cost){
                return 0;
            }else if(e1.cost < e2.cost){
                return -1;
            }else {
                return 1;
            }
        });
        pq.offer(new Edge(source, 0));
        distance[source] = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int u = cur.node;
            long cost = cur.cost;
            for(Edge e : G[u]) {
                int v =  e.node;
                long wt = e.cost;
                if(distance[v] > distance[u] + wt) {
                    distance[v] = distance[u] + wt;
                    pq.offer(new Edge(v, distance[v]));
                }
            }
        }
        return distance;
    }


    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        ArrayList<Edge>[] G = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            G[i] = new ArrayList<>();
        }
        for(int i=0; i<original.length; i++){
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            G[u].add(new Edge(v, cost[i]));
        }

        long [][] distance = new long[26][26];
        for (int i = 0; i < 26; i++) {
            long [] d = shortestPath(i, G);
            System.arraycopy(d, 0, distance[i], 0, 26);
        }
        long totalCost = 0l;
        for(int i=0; i<source.length(); i++){
            int u  = source.charAt(i) - 'a';
            int v =  target.charAt(i) - 'a';
            if(u != v){
                if(distance[u][v] == Integer.MAX_VALUE){
                    return -1l;
                }
                totalCost += distance[u][v];
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        char [] original = {'a','b','c','c','e','d'};
        char []changed = {'b','c','b','e','b','e'};
        int []cost = {2,5,5,1,2,20};
        MinimumCostToConvertString1 mc = new MinimumCostToConvertString1();
        System.out.println( mc.minimumCost("abcd", "acbe",original, changed,  cost));



        char [] original1 = {'a','c'};
        char [] changed1 = {'c','b'};
        int [] cost1 = {1, 2};
        System.out.println(mc.minimumCost("aaaa", "bbbb", original1, changed1, cost1));

        char [] original2 = {'a'};
        char [] changed2 = {'e'};
        int []cost2 = {10000};
        System.out.println(mc.minimumCost("abcd", "abce", original2, changed2, cost2));

    }
}
