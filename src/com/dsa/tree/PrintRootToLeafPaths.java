package com.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class PrintRootToLeafPaths {
    public static void solve(Node root, LinkedList<Integer> pr, ArrayList<ArrayList<Integer>> res){
        if(root == null) return;
        pr.addLast(root.data);
        if(root.left == null && root.right == null){
            res.add(new ArrayList<>(pr));
        }
        solve(root.left, pr, res);
        solve(root.right, pr, res);
        pr.removeLast();
    }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        solve(root, new LinkedList<>(), resList);
        return resList;
    }
    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        System.out.println(Paths(root));
    }
}
