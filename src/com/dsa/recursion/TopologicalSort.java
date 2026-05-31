package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class TopologicalSort {

    enum VertexState{
        NEW,
        ACTIVE,
        FINISHED;
    }

    public static void topoSortHelper(int u, ArrayList<Integer> G[], VertexState [] state, Stack<Integer> stack){
        state[u] = VertexState.ACTIVE;
        for(int v: G[u]){
            if(state[v] == VertexState.NEW){
                topoSortHelper(v, G, state, stack);
            }
        }
        stack.push(u);
        state[u] = VertexState.FINISHED;
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> G[] = new ArrayList[V];
        for(int i=0; i< V; i++){
            G[i]= new ArrayList<>();
        }
        for(int i=0; i< edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            G[u].add(v);
        }
        VertexState vertexState[] = new VertexState[V];
        Arrays.fill(vertexState, VertexState.NEW);
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i< V; i++) {
            if(vertexState[i] == VertexState.NEW) {
                topoSortHelper(i, G, vertexState, stack);
            }
        }
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
    public static void main(String[] args) {
        int [][] edges = {{3,0}, {1, 0}, {2, 0}};
        System.out.println(topoSort(4, edges));
    }
}
