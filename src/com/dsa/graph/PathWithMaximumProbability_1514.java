package com.dsa.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PathWithMaximumProbability_1514 {
    public class Node {
        int u;
        double prob;
        public Node(int u, double prob) {
            this.u = u;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<Node> [] G = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            G[i] = new ArrayList<Node>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            G[u].add(new Node(v, succProb[i]));
            G[v].add(new Node(u, succProb[i]));
        }
        double [] distance = new double[n];
        distance[start_node] = 1;

        PriorityQueue<Node> maxHeap = new PriorityQueue<>((e1, e2) -> Double.compare(e2.prob, e1.prob));
        maxHeap.offer(new Node(start_node, 1));

        while (!maxHeap.isEmpty()) {
            Node node = maxHeap.poll();
            int u =  node.u;
            double pr = node.prob;
            for(Node e: G[u]) {
                int v = e.u;
                double prob = e.prob;
                if(distance[v] < pr * prob) {
                    distance[v] = pr * prob;
                    maxHeap.offer(new Node(v, distance[v]));
                }
            }
        }

        return distance[end_node];
    }


    public static void main(String[] args) {
        PathWithMaximumProbability_1514 p = new PathWithMaximumProbability_1514();
        int n =3;
        int [][] edges = new int[][]{
                {0,1},
                {1,2},
                {0,2}
        };
        double [] succProb = {0.5,0.5,0.2};
        int start = 0, end = 2;
        System.out.println(p.maxProbability(n, edges, succProb, start, end));

    }
}
