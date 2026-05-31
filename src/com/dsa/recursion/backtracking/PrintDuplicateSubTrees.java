package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrintDuplicateSubTrees {
    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public static String dfs(Node root, HashMap<String, Integer> freq, List<Node> nodeList) {
        if (root == null) {
            return "";
        }
        String left = dfs(root.left, freq, nodeList);
        String right = dfs(root.right, freq, nodeList);
        String res =  left+ "#"  + "("+ root.data +")" + "$" +right;
        if(freq.getOrDefault(res, 0) == 1){
            nodeList.add(root);
        }
        freq.put(res,freq.getOrDefault(res,0)+1);
        return res;
    }
    public static List<Node> printAllDuplicates(Node root) {
        List<Node> res = new ArrayList<>();
        dfs(root, new HashMap<>(), res);
        return res;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);
        System.out.println(printAllDuplicates(root).size());

    }
}
