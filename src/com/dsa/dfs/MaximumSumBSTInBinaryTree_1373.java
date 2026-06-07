package com.dsa.dfs;

public class MaximumSumBSTInBinaryTree_1373 {
    // Correct answer

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

    public static class Node{
        boolean isBst;
        int sum;
        Integer min;
        Integer max;
        public Node(boolean isBst, int sum, Integer min, Integer max) {
            this.isBst = isBst;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    public Node dfs(TreeNode root, int []maxSum){
        if(root == null){
            return new Node(true, 0, null, null);
        }

        Node left = dfs(root.left, maxSum);
        Node right = dfs(root.right, maxSum);

        boolean isRootBst = left.isBst && right.isBst
                &&  (right.min == null ||  root.val < right.min)
                &&  (right.max == null ||  root.val > left.max);
        int sumWithRoot = left.sum + right.sum + root.val;
        Integer maxWithRoot = Math.min(root.val, right.min == null ? root.val: right.min);
        Integer minWithRoot = Math.max(root.val, left.max  == null ? root.val: left.max);
        if(isRootBst){
            maxSum[0]= Math.max(maxSum[0], sumWithRoot);
        }
        Node node = new Node(isRootBst, sumWithRoot, minWithRoot, maxWithRoot);
        return node;
    }

    public int maxSumBST(TreeNode root) {
        int [] maxSum = new int[]{0};
        dfs(root, maxSum);
        return maxSum[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);
        MaximumSumBSTInBinaryTree_1373 maximumSumBSTInBinaryTree1373 =  new MaximumSumBSTInBinaryTree_1373();
        System.out.println( maximumSumBSTInBinaryTree1373.maxSumBST(root));


        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(3);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(2);
        System.out.println( maximumSumBSTInBinaryTree1373.maxSumBST(treeNode));


    }
}
