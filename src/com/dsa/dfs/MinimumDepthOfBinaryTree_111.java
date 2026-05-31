package com.dsa.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree_111 {
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

    public static class TreeNodeWithHeight{
        TreeNode node;
        int height;
        TreeNodeWithHeight(TreeNode node, int height) {
            this.node = node;
            this.height = height;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNodeWithHeight> queue = new LinkedList<>();
        queue.offer(new TreeNodeWithHeight(root, 1));
        while (!queue.isEmpty()) {
            TreeNodeWithHeight n = queue.poll();
            TreeNode node = n.node;
            if (node.left == null && node.right == null) {
                return n.height;
            }

            if (node.left != null) {
                queue.offer(new TreeNodeWithHeight(node.left, n.height + 1));
            }
            if (node.right != null) {
                queue.offer(new TreeNodeWithHeight(node.right, n.height + 1));
            }

        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
