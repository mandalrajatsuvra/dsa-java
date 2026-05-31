package com.dsa.dfs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {

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

    public void dfs(TreeNode root, String pr, List<String> res ){
        if(root == null){
            return;
        }
        if(pr.isEmpty()){
            pr += root.val;
        }else{
            pr += "->"+root.val;
        }
        if(root.left == null && root.right == null){
            res.add(pr);
        }
        dfs(root.left, pr, res);
        dfs(root.right, pr, res);
        if(pr.contains("->")){
            pr = pr.substring(0, pr.indexOf("->"));
        }else{
            pr = "";
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }
    public static void main(String[] args) {

    }
}
