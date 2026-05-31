package com.dsa.dfs;

public class BinaryTreeBalanced_110 {
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


    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0, 1};
        }
        int [] left = dfs(root.left);
        if(left[1] == 0){
            return left;
        }
        int [] right = dfs(root.right);
        if(right[1] == 0){
            return right;
        }
        int height = Math.max(left[0], right[0]) + 1;
        int isHeightBalanced = Math.abs(left[0] - right[0]) > 1 ? 0: 1;
        return new int[]{height, isHeightBalanced};
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root)[1] == 1;
    }

    public static void main(String[] args) {

    }
}
