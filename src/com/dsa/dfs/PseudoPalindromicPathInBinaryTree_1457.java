package com.dsa.dfs;

public class PseudoPalindromicPathInBinaryTree_1457 {
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
    public void dfs(TreeNode root, int [] freq, int [] res){
        if(root == null) return;
        freq[root.val]++;
        if(root.left == null && root.right == null){
            if(isPseudoPalindrome(freq)){
                res[0]++;
            }
        }
        dfs(root.left, freq, res);
        dfs(root.right, freq, res);
        freq[root.val]--;
    }
    private boolean isPseudoPalindrome(int[] freq) {
        int odd = 0;
        int even = 0;
        for(int i = 0; i < freq.length; i++){
            if(freq[i] % 2 == 0){
                even++;
            }else{
                odd++;
            }
        }
        return odd <= 1;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        int res [] = new int[] {0};
        dfs(root,new int[10], res);
        return res[0];
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        PseudoPalindromicPathInBinaryTree_1457 ps = new PseudoPalindromicPathInBinaryTree_1457();
        System.out.println( ps.pseudoPalindromicPaths(root));
    }
}
