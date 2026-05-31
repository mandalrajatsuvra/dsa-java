package com.dsa.dfs;

public class BinaryTreeHeight_94 {
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
    public int height(TreeNode root){
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        BinaryTreeHeight_94 ob = new BinaryTreeHeight_94();
        System.out.println(ob.height(root));

    }
}
