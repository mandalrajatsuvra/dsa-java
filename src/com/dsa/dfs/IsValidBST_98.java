package com.dsa.dfs;

public class IsValidBST_98 {
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

    public boolean dfs(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }
        return isRootValueLiesBetween(root, min, max)
                && dfs(root.left, min, root.val)
                && dfs(root.right, root.val, max);
    }

    public boolean isRootValueLiesBetween(TreeNode root, Integer min, Integer max ){
        boolean isRootGreaterThanMin = false;
        boolean isRootLessThanMax = false;
        if(min == null){
            isRootGreaterThanMin = true;
        }
        if(max == null){
            isRootLessThanMax = true;
        }
        if(min != null){
            isRootGreaterThanMin = root.val > min;
        }
        if(max != null){
            isRootLessThanMax = root.val < max;
        }
        return isRootGreaterThanMin && isRootLessThanMax;
    }


    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(10);
       /* root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);*/
        IsValidBST_98 isValidBST_98 = new IsValidBST_98();
        System.out.println(isValidBST_98.isValidBST(root));


    }
}
