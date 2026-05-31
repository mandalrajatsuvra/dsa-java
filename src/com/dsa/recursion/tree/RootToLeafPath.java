package com.dsa.recursion.tree;


import java.util.ArrayList;




class Solution {

    public static void dfs(Node root, ArrayList<Integer> pr, ArrayList<ArrayList<Integer>> res){
        if(root == null) return;
        pr.add(root.data);
        if(root.left == null && root.right == null){
            res.add(new ArrayList<>(pr));
        }
        dfs(root.left, pr, res);
        dfs(root.right, pr, res);
        pr.remove(pr.size()-1);
    }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> pr = new ArrayList<>();
        dfs(root, pr, res);
        return res;
    }
}
public class RootToLeafPath {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        ArrayList<ArrayList<Integer>> res = Solution.Paths(root);
        System.out.println(res);
    }
}
