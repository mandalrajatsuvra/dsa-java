package com.dsa.bfs;

import java.util.*;

public class PrintBinaryTree_655 {

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

    public  int height (TreeNode root){
        if(root == null) return 0;

        if(root.left == null && root.right == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);

    }

    public  class TreeNodeWithPos{
        TreeNode node;
        int row;
        int col;
        public TreeNodeWithPos(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }


    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();

        int height = height(root);
        int col = (int)Math.pow(2, height+1)-1;
        String [][] table = new String[height+1][col];
        for(String [] s: table){
            Arrays.fill(s,"");
        }

        int currentCol = col/2;

        Queue<TreeNodeWithPos> queue = new LinkedList<>();
        queue.offer(new TreeNodeWithPos(root, 0,  currentCol));

        while(!queue.isEmpty()){
            TreeNodeWithPos nodeWithPos = queue.poll();
            table[nodeWithPos.row][nodeWithPos.col] = String.valueOf(nodeWithPos.node.val);
            TreeNode node = nodeWithPos.node;
            if(node.left != null){
                queue.offer(new TreeNodeWithPos(node.left, nodeWithPos.row+1, nodeWithPos.col- (int)Math.pow(2, height-nodeWithPos.row-1)));
            }
            if(node.right != null){
                queue.offer(new TreeNodeWithPos(node.right, nodeWithPos.row+1 , nodeWithPos.col + (int)Math.pow(2, height- nodeWithPos.row -1)));
            }
        }

        for(int i = 0; i < table.length; i++){
            res.add(new ArrayList<>(Arrays.asList(table[i])));
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        PrintBinaryTree_655 pb = new PrintBinaryTree_655();
        List<List<String>> res = pb.printTree(root);
        System.out.println(res);


    }
}
