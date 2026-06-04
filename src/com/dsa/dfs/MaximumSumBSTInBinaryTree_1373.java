package com.dsa.dfs;

public class MaximumSumBSTInBinaryTree_1373 {
    // Wrong ans have to work on it

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

    public static class NodeWithInformation{
        boolean isBst;
        int sum;
        TreeNode root;
        public NodeWithInformation(boolean isBst, int sum, TreeNode root) {
            this.isBst = isBst;
            this.sum = sum;
            this.root = root;
        }
    }

    public NodeWithInformation dfs(TreeNode root, TreeNode parent, int []maxSum){
        if(root == null){
            return new NodeWithInformation(true,0, new TreeNode(parent.left == root ? Integer.MIN_VALUE : Integer.MAX_VALUE));
        }
        if(root.left == null && root.right == null){
            return new NodeWithInformation(true, root.val, root);
        }

        NodeWithInformation left = dfs(root.left, root, maxSum);
        NodeWithInformation right = dfs(root.right, root, maxSum);

        int sum = 0;
        boolean isBst = false;
        if(left.isBst && right.isBst){
            if(root.val > left.root.val && root.val < right.root.val){
                sum += left.sum;
                sum += right.sum;
                sum += root.val == Integer.MAX_VALUE || root.val == Integer.MIN_VALUE  ? 0 : root.val ;
                isBst = true;
            }
        }
        maxSum[0] = Math.max(maxSum[0], sum);
        return new NodeWithInformation(isBst, sum, root);
    }

    public int maxSumBST(TreeNode root) {
        int [] maxSum = new int[]{0};
        dfs(root, null, maxSum);
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
    }
}
