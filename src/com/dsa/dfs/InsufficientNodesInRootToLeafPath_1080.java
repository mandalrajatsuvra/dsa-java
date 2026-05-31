package com.dsa.dfs;

public class InsufficientNodesInRootToLeafPath_1080 {
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

    public boolean dfs(TreeNode root, int pathSum, int limit){
        if(root == null){
            return false;
        }

        pathSum = pathSum + root.val;

        if(root.left==null && root.right==null){
            return pathSum > limit;
        }

        boolean isLeftGood = dfs(root.left,pathSum,limit);
        boolean isRightGood = dfs(root.right,pathSum,limit);

        if(!isLeftGood){
            root.left = null;
        }
        if(!isRightGood){
            root.right = null;
        }
        return isLeftGood || isRightGood;
    }


    public TreeNode sufficientSubset(TreeNode root, int limit) {
        dfs(root,0,limit);
        return root;
    }

    public static void main(String[] args) {

    }
}
