package com.dsa.tree;


import java.util.ArrayList;
import java.util.List;

/*      0
     1     2
  3    4  5  2
*/

public class RootToLeafSumRecursive {
    public static void dfs(TreeNode root, int target, List<Integer> pr, List<List<Integer>> res){
        if(root == null) return;
        target = target - root.data;
        pr.add(root.data);
        if(root.left == null && root.right == null){
            if(target == 0){
                res.add(new ArrayList<>(pr));
            }
        }
        dfs(root.left, target, pr, res);
        target = target + root.data;
        pr.remove(pr.size() - 1);
        dfs(root.right, target, pr, res);
    }

    public static List<List<Integer>> rootToLeafRecursive(TreeNode node, int target){
        List<List<Integer>> res = new ArrayList<>();
        dfs(node, target, new ArrayList<>(), res);
        return res;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(2);
        System.out.println(rootToLeafRecursive(root, 4));
    }
}
