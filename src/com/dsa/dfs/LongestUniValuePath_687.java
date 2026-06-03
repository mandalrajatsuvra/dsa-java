package com.dsa.dfs;

public class LongestUniValuePath_687 {
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

    public static class NodeWithPath{
        TreeNode node;
        int pathLength;
        NodeWithPath(TreeNode node, int pathLength) {
            this.node = node;
            this.pathLength = pathLength;
        }
    }

    public NodeWithPath dfs(TreeNode root, int [] cnt){
        if(root == null){
            return new NodeWithPath(new TreeNode(Integer.MIN_VALUE),0);
        }

        if(root.left == null && root.right == null){
            return new NodeWithPath(root,1);
        }

        NodeWithPath left =  dfs(root.left, cnt);
        NodeWithPath right = dfs(root.right, cnt);

        int totalPathLength = 0;
        if(left.node.val == root.val && right.node.val == root.val){
            totalPathLength = left.pathLength + right.pathLength + 1;
            cnt[0] = Math.max(cnt[0],totalPathLength);
            return new NodeWithPath(root,  1 + Math.max(left.pathLength, right.pathLength));
        }else if(left.node.val == root.val){
            totalPathLength = left.pathLength + 1;
            cnt[0] = Math.max(cnt[0],totalPathLength);
            return new NodeWithPath(root,  1 + left.pathLength);

        }else if(right.node.val == root.val){
            totalPathLength = right.pathLength + 1;
            cnt[0] = Math.max(cnt[0],totalPathLength);
            return new NodeWithPath(root,  1 + right.pathLength);
        }else{
            totalPathLength = 1;
            cnt[0] = Math.max(cnt[0],totalPathLength);
            return new NodeWithPath(root,  1);
        }
    }



    public int longestUniValuePath(TreeNode root) {
        int []cnt = new int[]{0};
        dfs(root, cnt);
        return cnt[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        LongestUniValuePath_687 res = new LongestUniValuePath_687();
        System.out.println(res.longestUniValuePath(root));

    }
}
