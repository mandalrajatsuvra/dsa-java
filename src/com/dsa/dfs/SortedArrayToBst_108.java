package com.dsa.dfs;

import com.sun.source.tree.Tree;

public class SortedArrayToBst_108 {
    public static class TreeNode {
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

    public TreeNode dfs(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = dfs(arr, start, mid - 1);
        root.right = dfs(arr, mid + 1, end);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }
    public static void main(String[] args) {

    }
}
