package com.dsa.dfs;

public class MinimumAbsoluteDifference_530 {

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

    public void dfs(TreeNode root, int [] previous, int [] minDiff){
        if(root == null) return;
        dfs(root.left, previous, minDiff);
        if(previous[0] == -1){
            previous[0] = root.val;
        }else{
            minDiff[0] = Math.min(minDiff[0],  Math.abs(root.val-previous[0]));
            previous[0] = root.val;
        }
        dfs(root.right, previous, minDiff);
    }

    public int getMinimumDifference(TreeNode root) {
        int [] previous = new int[]{-1};
        int [] minDiff = new int[]{Integer.MAX_VALUE};
        dfs(root, previous, minDiff);
        return minDiff[0];
    }


    public static void main(String[] args) {

    }
}
