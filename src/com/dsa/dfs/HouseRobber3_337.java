package com.dsa.dfs;

public class HouseRobber3_337 {

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

    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }
        int []left = dfs(root.left);
        int []right = dfs(root.right);
        int take = root.val+ left[1] + right[1];
        int notTake = Math.max(left[0], right[0]) + Math.max(left[1], right[1]);

        return new int[]{take, notTake};
    }

    public int rob(TreeNode root) {
        int [] res =  dfs(root);
        return Math.max(res[0], res[1]);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        HouseRobber3_337 ob = new HouseRobber3_337();
        System.out.println(ob.rob(root));
    }
}
