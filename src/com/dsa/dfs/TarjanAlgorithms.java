package com.dsa.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TarjanAlgorithms {

    public static int clock = 0;

    public static void findLowDFS(int u, ArrayList<Integer>[] G, int [] low, int [] pre, boolean[] visited, Stack<Integer> stack, boolean[] popped, ArrayList<ArrayList<Integer>> res){
        visited[u] = true;
        clock = clock + 1;
        pre[u] = clock;
        low[u] = pre[u];
        stack.push(u);
        for(int v: G[u]){
            if(!visited[v]){
                findLowDFS(v, G, low, pre, visited, stack, popped, res);
                low[u] = Math.min(low[u], low[v]);
            }else if(!popped[v]){
                low[u] = Math.min(low[u], pre[v]);
            }
        }
        if(low[u] == pre[u]){
            int top;
            ArrayList<Integer> temp = new ArrayList<>();
            do{
                top  = stack.peek();
                popped[top] = true;
                temp.add(top);
                stack.pop();
            }while (top !=  u );
            res.add(temp);
        }
    }
    public static void findLow(int n, int [][] edges){
        ArrayList<Integer> [] G =  new ArrayList[n];
        for(int i = 0; i < n; i++){
            G[i] = new ArrayList<>();
        }
        for(int [] edge: edges){
            int u =  edge[0];
            int v =  edge[1];
            G[u].add(v);
        }
        boolean[] visited = new boolean[n];
        int [] low = new int [n];
        int [] pre =  new int [n];
        boolean[] popped = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                findLowDFS(i, G, low, pre, visited, stack, popped, res);
            }
        }
        System.out.println(Arrays.toString(low));
        System.out.println(Arrays.toString(pre));
        System.out.println(res);
    }
    public static void main(String[] args) {
        clock = 0;
        int n = 9;
        int [][] edges = {{0,1}, {1,2}, {2, 3}, {3,0}, {4,1}, {4, 5} ,{2,6}, {6,7}, {7,8}, {8,6}};
        findLow(n, edges);
    }
}
