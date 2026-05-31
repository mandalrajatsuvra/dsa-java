package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestCycleInAGraph_2608 {

    public enum  Color {
        WHITE,
        GRAY,
        BLACK
    }
    public void dfs(int u, int p, Stack<Integer> stack, Color[] color, ArrayList<Integer> [] G, int [] minLength){

        color[u] = Color.GRAY;
       // parent[u] = p;
        //parent[u] = p;
        stack.push(u);

        for(int v : G[u]){
            if(color[v] == Color.GRAY && v != p){
                int w = u;
                int cnt = 1;
                List<Integer> cycle = new ArrayList<>();
                cycle.add(v);

                Stack<Integer> s2 = (Stack<Integer>) stack.clone();


                while (!s2.isEmpty() && s2.peek() != v){
                    cycle.add(s2.peek());
                    s2.pop();
                    cnt++;
                }
                if(!s2.isEmpty() && s2.peek() == v){
                    cycle.add(s2.peek());
                    s2.pop();
                    if(cycle.size() > 2) {
                        System.out.println(cycle);
                    }
                }

                //System.out.println(Arrays.toString(parent));
                //minLength[0] =  Math.min(minLength[0], cycle.size()-1);
            }
            if(color[v] == Color.WHITE){
                dfs(v,u,stack,color,G, minLength);
            }
        }

        color[u] = Color.BLACK;
        stack.pop();
        //parent[u] = -1;
    }


    public int findShortestCycle(int n, int[][] edges) {
        ArrayList<Integer>[] G = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            G[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            int u  = edge[0];
            int v = edge[1];
            G[u].add(v);
            G[v].add(u);
        }

        int [] minLength = new int[]{Integer.MAX_VALUE};

        int [] parents = new int[n];
        Arrays.fill(parents, -1);

        for(int u =0; u < n; u++){
            Stack<Integer> stack = new Stack<>();
            Color[] colors = new Color[n];
            Arrays.fill(colors, Color.WHITE);
            if(colors[u] == Color.WHITE){
                dfs(u, -1, stack, colors, G, minLength);
            }
        }
        return  minLength[0] == Integer.MAX_VALUE ? -1 : minLength[0];
    }


    public static void main(String[] args) {
        ShortestCycleInAGraph_2608 s = new ShortestCycleInAGraph_2608();
        int n = 7;
        int[][] edges = new int[][]{
                {0,1},
                {1,2},
                {2,0},
                {3,4},
                {4,5},
                {5,6},
                {6,3},
        };
        System.out.println(s.findShortestCycle(n, edges));

        int n1 = 4;
        int[][] edges1 = new int[][]{
                {0,1},
                {0,2},
        };
        System.out.println(s.findShortestCycle(n1, edges1));

        int[][] arr = {
                {4, 5},
                {1, 6},
                {6, 4},
                {5, 3},
                {3, 6},
                {0, 2},
                {5, 8},
                {0, 6},
                {3, 0},
                {6, 8},
                {2, 8},
                {1, 2},
                {9, 4}
        };
        System.out.println(s.findShortestCycle(10, arr));
    }
}
