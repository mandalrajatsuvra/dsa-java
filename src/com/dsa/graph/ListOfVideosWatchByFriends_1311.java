package com.dsa.graph;

import java.util.*;

public class ListOfVideosWatchByFriends_1311 {


    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        Map<String, Integer> videosSeenFreq =  new HashMap<>();
        Queue<int []> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[id] = true;
        q.offer(new int[] {id, 0});

        while (!q.isEmpty()) {
            int [] node = q.poll();
            int u = node[0];
            int lev = node[1];
            if(lev == level) {
                List<String> watched = watchedVideos.get(u);
                for(String w : watched) {
                    videosSeenFreq.put(w, videosSeenFreq.getOrDefault(w, 0) + 1);
                }
            }
            for(int v: friends[u]){
                if(!visited[v]){
                    visited[v] = true;
                    q.offer(new int[] {v, lev+1});
                }
            }
        }
        List<String> result = new ArrayList<>();
        PriorityQueue<String> minHeap = new PriorityQueue<>((a,b)->{
             if(videosSeenFreq.get(a) != videosSeenFreq.get(b)) return videosSeenFreq.get(a) - videosSeenFreq.get(b);
             return a.compareTo(b);
        });
        for(String key: videosSeenFreq.keySet()){
            minHeap.add(key);
        }
        while (!minHeap.isEmpty()){
            result.add(minHeap.poll());
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
