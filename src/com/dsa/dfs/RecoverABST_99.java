package com.dsa.dfs;

import java.util.ArrayList;
import java.util.List;

public class RecoverABST_99 {
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

    public void dfs(TreeNode root, List<TreeNode> list){
        if(root == null) return;
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }

    public void recoverTree(TreeNode root) {
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        boolean isFirstTime = true;
        for(int i = 1; i < list.size(); i++){
             if(list.get(i-1).val > list.get(i).val){
                 if(isFirstTime){
                     firstNode = list.get(i-1);
                 };
                 secondNode = list.get(i);
                 isFirstTime = false;
             }
        }
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    public static void main(String[] args) {

    }
}
