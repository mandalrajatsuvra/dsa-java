package com.dsa.dfs;

import java.util.HashMap;
import java.util.Map;

public class ConstructATreeFromInorderAndPostorderTraversal_106 {


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


    public TreeNode dfs(int [] postorder, int [] inorder, int ins, int ine, int []pri, Map<Integer, Integer> map) {
        if(ins > ine){
            return null;
        }
        int mid = map.get(postorder[--pri[0]]);
        TreeNode root = new TreeNode(inorder[mid]);
        root.right = dfs(postorder, inorder,mid + 1, ine,pri, map);
        root.left = dfs(postorder, inorder, ins,mid -1, pri, map);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return dfs(postorder,inorder, 0, n-1, new int[]{n}, inorderMap);
    }

    public static void main(String[] args) {

    }
}
