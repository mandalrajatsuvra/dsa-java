package com.dsa.dfs;

public class DiameterOfBinaryTree_543 {
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

    public int dfs(TreeNode root, int [] diameter){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left, diameter);
        int right = dfs(root.right, diameter);
        diameter[0] = Math.max(diameter[0],   left + right+ 1);
        return Math.max(left, right) + 1;
    }


    public int diameterOfBinaryTree(TreeNode root) {
        int [] diameter = new int[1];
        dfs(root, diameter);
        return diameter[0]-1;
    }

    public static void main(String[] args) {

    }
}
