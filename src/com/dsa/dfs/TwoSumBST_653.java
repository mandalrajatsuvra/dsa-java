package com.dsa.dfs;

import java.util.HashSet;

public class TwoSumBST_653 {
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

    public boolean dfs(TreeNode root, int target, HashSet<Integer> set){
        if(root == null){
            return false;
        }
        if(set.contains(target - root.val)){
            return true;
        }
        set.add(root.val);
        return dfs(root.left, target, set) || dfs(root.right, target, set);
    }

    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k, new HashSet<>());
    }

    public static void main(String[] args) {

    }
}
