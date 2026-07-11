package com.dsa.codeforces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ALoveTriangle {


    public enum  Color {
        WHITE,
        GRAY,
        BLACK
    }

    public static boolean dfs(int u, int p, int [] parent, ArrayList<Integer>[] G, Color[] color){
        color[u] = Color.GRAY;
        parent[u] = p;
        for(int v: G[u]){
            if(color[v] == Color.WHITE){
                if(dfs(v,u,parent,G,color)){
                    return true;
                }
            }else if(color[v] == Color.GRAY){
                int t = u;
                int cnt = 0;
                while(t != -1 &&  t != v){
                    cnt ++;
                    t = parent[t];
                }
                if(cnt == 2){
                    return true;
                }
                return  false;
            }
        }
        parent[u] = -1;
        color[u] = Color.BLACK;
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> [] G = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            G[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt()-1;
            G[i].add(v);
        }
        Color[] color = new Color[n];
        int [] parent = new int[n];
        Arrays.fill(color, Color.WHITE);
        for(int i = 0; i < n; i++){
            if(color[i] == Color.WHITE){
                if(dfs(i, -1, parent, G, color)){
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }

}
