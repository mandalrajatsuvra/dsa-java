package com.dsa.graph;

import java.util.*;

public class CourseSchedule4_1462 {
    // Solution is Correct
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<Integer>[] G = new ArrayList[numCourses];
        HashMap<Integer, HashSet<Integer>> prerequisitesMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            G[i] = new ArrayList<>();
            prerequisitesMap.put(i, new HashSet<>());
        }
        int [] indegrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int u  = prerequisites[i][0];
            int v = prerequisites[i][1];
            indegrees[v]++;
            G[u].add(v);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int u  = queue.poll();
            for(int v: G[u]){
                indegrees[v]--;
                prerequisitesMap.get(v).add(u);
                prerequisitesMap.get(v).addAll(prerequisitesMap.get(u));
                if(indegrees[v]==0){
                    queue.add(v);
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int i=0; i< queries.length; i++){
            int u = queries[i][0];
            int v = queries[i][1];
            HashSet<Integer> set = prerequisitesMap.get(v);
            if(set.contains(u)){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int noOfCourses = 2;
        int[][] prerequisites = new int[][]{
                {1, 0}
        };
        int[][] queries = new int[][]{{0,1}, {1,0}};
        CourseSchedule4_1462 cs = new CourseSchedule4_1462();
        List<Boolean> res = cs.checkIfPrerequisite(noOfCourses, prerequisites, queries);
        System.out.println(res);

    }
}
