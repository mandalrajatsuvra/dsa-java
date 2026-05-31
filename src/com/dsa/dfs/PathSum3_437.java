package com.dsa.dfs;

import java.util.HashMap;
import java.util.Map;

public class PathSum3_437 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void dfs(TreeNode root, int target, long sum, Map<Long, Integer> freq, int []cnt){
        if(root == null) return;

        sum += root.val;
        if(freq.containsKey(sum-target)){
            cnt[0] += freq.get(sum-target);
        }
        freq.put(sum, freq.getOrDefault(sum,0)+1);
        dfs(root.left, target, sum, freq, cnt);
        dfs(root.right, target, sum, freq, cnt);

        int currFreq = freq.getOrDefault(sum, 0);
        if(currFreq > 0){
            freq.put(sum, currFreq-1);
        }

    }
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> freq = new HashMap<>();
        freq.put(0l, 1);
        int []cnt = new int[]{0};
        dfs(root, targetSum, 0, freq, cnt);
        return cnt[0];
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.right.right = new TreeNode(11);
        PathSum3_437 pathSum3_437 = new PathSum3_437();
        System.out.println(pathSum3_437.pathSum(root, 8));
    }
}
