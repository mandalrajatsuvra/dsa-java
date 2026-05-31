package com.dsa.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class PathSumBFS_112 {
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

    public static class NodeWithSum{
        TreeNode node;
        int sum;
        NodeWithSum(TreeNode node, int sum){
            this.node = node;
            this.sum = sum;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        Queue<NodeWithSum> queue = new LinkedList<>();
        queue.add(new NodeWithSum(root,root.val));

        while(!queue.isEmpty()){
            NodeWithSum n =  queue.poll();
            TreeNode node = n.node;
            int sum = n.sum;
            if(node.left == null && node.right == null){
                if(sum == targetSum){
                    return true;
                }
            }
            if(node.left != null){
                queue.add(new NodeWithSum(node.left,sum+node.left.val));
            }
            if(node.right != null){
                queue.add(new NodeWithSum(node.right,sum+node.right.val));
            }
        }
        return false;
    }
    public boolean dfs(TreeNode root, int targetSum){
        if(root == null){
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null){
            return targetSum == 0;
        }
        boolean res = dfs(root.left,targetSum) || dfs(root.right,targetSum);
        targetSum += root.val;
        return res;
    }

    public static void main(String[] args) {

    }
}
