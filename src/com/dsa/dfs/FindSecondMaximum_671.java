package com.dsa.dfs;

import java.util.TreeSet;

public class FindSecondMaximum_671 {

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
    public void dfs(TreeNode root, TreeSet<Integer> container){
        if(root == null){
            return;
        }
        container.add(root.val);
        if(container.size() > 2){
            container.removeLast();
        }
        dfs(root.left, container);
        dfs(root.right, container);
    }

    public int findSecondMinimumValue(TreeNode root) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        dfs(root, treeSet);
        if(treeSet.size() == 2){
            return treeSet.last();
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
