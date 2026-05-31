package com.dsa.dfs;

public class DeleteNodeInBST_450 {
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                TreeNode cur = root.right;
                TreeNode node = cur;
                while(node.left != null){
                    node = node.left;
                }
                int temp =  root.val;
                root.val = node.val;
                node.val = temp;
                root.right = deleteNode(root.right, temp);
            }
        }
        return root;
    }
    public static void main(String[] args) {

    }
}
