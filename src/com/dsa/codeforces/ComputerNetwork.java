package com.dsa.codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComputerNetwork {

    public static boolean dfs(int u, ArrayList<Integer>[] G, List<Integer> path, boolean[] visited){
        visited[u]=true;
        path.add(u+1);
        if(u == G.length-1){
            return true;
        }
        for(int v:G[u]){
            if(!visited[v]){
                if(dfs(v,G,path,visited)){
                    return true;
                }
            }
        }
        visited[u]=false;
        path.remove(path.size()-1);
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        ArrayList<Integer>[] G = new ArrayList[len];
        for(int i=0;i<len;i++){
            G[i] = new ArrayList<>();
        }
        for(int i=2;i<=len;i++){
            int a = sc.nextInt();
            G[a-1].add(i-1);
            G[i-1].add(a-1);
        }
        boolean[] visited = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(0,G,path,visited);
        for(int e:path){
            System.out.print(e+" ");
        }

    }
}
