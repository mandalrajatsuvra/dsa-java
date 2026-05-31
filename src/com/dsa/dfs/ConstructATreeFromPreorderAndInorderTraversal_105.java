package com.dsa.dfs;

import java.util.HashMap;
import java.util.Map;

public class ConstructATreeFromPreorderAndInorderTraversal_105 {

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


    public TreeNode dfs(int [] preorder, int [] inorder, int ins, int ine, int []pri, Map<Integer, Integer> map) {
            if(ins > ine){
                return null;
            }
            int mid = map.get(preorder[pri[0]]);
            pri[0] = pri[0] + 1;
            TreeNode root = new TreeNode(inorder[mid]);
            root.left = dfs(preorder, inorder, ins,mid -1, pri, map);
            root.right = dfs(preorder, inorder,mid + 1, ine,pri, map);
            return root;
    }  


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i< inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, n-1, new int[]{0}, map);
    }

    public static void main(String[] args) {

    }
}
