package com.dsa.graph;

public class UndirectedGraphCycleDSU {

    public class UnionFindBySize{
        int [] parent;
        int [] size;
        public UnionFindBySize(int V){
            parent = new int[V];
            size = new int[V];
            for(int i = 0; i < V; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int u){
            if(u == parent[u]){
                return u;
            }
            parent[u] = find(parent[u]);
            return parent[u];
        }
        public void union(int u, int v){
            int pu = find(u);
            int pv = find(v);
            if(pu == pv){
                return;
            }
            if(size[pu] < size[pv]){
                parent[pu] = pv;
                size[pv] += size[pu];
            }else{
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
        public boolean connected(int u, int v){
            return find(u) == find(v);
        }
    }

    public boolean isCycle(int V, int[][] edges) {
        UnionFindBySize ufs = new UnionFindBySize(V);
        for(int [] edge: edges){
            int u = edge[0];
            int v = edge[1];
            if(ufs.connected(u, v)){
                return true;
            }else{
                ufs.union(u, v);
            }

        }
        return false;
    }

    public static void main(String[] args) {

    }
}
