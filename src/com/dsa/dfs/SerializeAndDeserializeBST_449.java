package com.dsa.dfs;

import java.util.HashMap;
import java.util.Map;

public class SerializeAndDeserializeBST_449 {
    // Correct solutions
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
    // Encodes a tree to a single string.

    public void print(TreeNode root){
        if(root==null){
            return;
        }
        print(root.left);
        System.out.println(root.val);
        print(root.right);
    }
    public void inorder(TreeNode root, StringBuilder sb){
        if(root==null){
            return;
        }
        inorder(root.left,sb);
        if(sb.isEmpty()){
            sb.append(root.val);
        }else{
            sb.append(",").append(root.val);
        }
        inorder(root.right,sb);
    }
    public void preorder(TreeNode root, StringBuilder sb){
        if(root==null){
            return;
        }
        if(sb.isEmpty()){
            sb.append(root.val);
        }else{
            sb.append(",").append(root.val);
        }
        preorder(root.left,sb);
        preorder(root.right,sb);
    }
    public String serialize(TreeNode root) {
        StringBuilder inOrder = new StringBuilder("");
        StringBuilder preOrder = new StringBuilder("");
        inorder(root,inOrder);
        preorder(root,preOrder);
        return inOrder.toString() + "#" + preOrder.toString();
    }


    public TreeNode dfs(String [] preorder, String [] inorder, int ins, int ine, int []pri, Map<String, Integer> map) {
        if(ins > ine){
            return null;
        }
        int mid = map.get(preorder[pri[0]]);
        pri[0] = pri[0] + 1;
        TreeNode root = new TreeNode(Integer.parseInt(inorder[mid]));
        root.left = dfs(preorder, inorder, ins,mid -1, pri, map);
        root.right = dfs(preorder, inorder,mid + 1, ine,pri, map);
        return root;
    }
    public TreeNode buildTree(String[] preorder, String[] inorder) {
        int n = inorder.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i< inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, n-1, new int[]{0}, map);
    }
    public TreeNode deserialize(String data) {
       String []inOrderAndPreOrderData = data.split("#");
       String [] preOrderData = inOrderAndPreOrderData[1].split(",");
       String [] inOrderData = inOrderAndPreOrderData[0].split(",");
       return buildTree(preOrderData, inOrderData);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        SerializeAndDeserializeBST_449 s = new SerializeAndDeserializeBST_449();
        String serialized =  s.serialize(root);
        TreeNode treeNode = s.deserialize(serialized);
        s.print(treeNode);

        System.out.println(serialized);
    }



}
