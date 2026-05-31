package com.dsa.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigZagLevelOrderTraversal_103 {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> firstStack = new Stack<>();
        Stack<TreeNode> secondStack = new Stack<>();
        boolean isFirstStack = true;
        firstStack.push(root);

        while (!firstStack.isEmpty()) {
            int size = firstStack.size();
            List<Integer> pr = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = firstStack.pop();
                pr.add(node.val);
                if(isFirstStack) {
                    if (node.left != null) {
                        secondStack.push(node.left);
                    }
                    if (node.right != null) {
                        secondStack.push(node.right);
                    }
                }else{
                    if(node.right != null){
                        secondStack.push(node.right);
                    }
                    if(node.left != null){
                        secondStack.push(node.left);
                    }
                }
            }
            res.add(pr);
            isFirstStack = !isFirstStack;
            Stack<TreeNode> tempStack = secondStack;
            secondStack = firstStack;
            firstStack = tempStack;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeZigZagLevelOrderTraversal_103 obj = new BinaryTreeZigZagLevelOrderTraversal_103();
        List<List<Integer>> res = obj.zigzagLevelOrder(root);
        System.out.println(res);


    }
}
