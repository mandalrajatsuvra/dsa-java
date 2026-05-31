package com.dsa.dfs;

import java.util.*;

public class SumRootToLeaf_1022 {
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

    public void dfs(TreeNode root, List<Integer> pr, List<List<Integer>> res){
        if(root == null){
            return;
        }
        pr.add(root.val);
        if(root.left == null && root.right == null){
            res.add(new ArrayList<>(pr));
        }
        dfs(root.left,pr,res);
        dfs(root.right,pr,res);
        pr.remove(pr.size()-1);
    }
    public int sumRootToLeafRecursive(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pr = new ArrayList<>();
        dfs(root, pr, res);
        int sum = 0;
        for(List<Integer> list : res){
            Collections.reverse(list);
            int num = 0;
            for(int i=0; i<list.size(); i++){
                num += list.get(i) * Math.pow(2,i);
            }
            sum += num;
        }
        return sum;
    }

    class NodeWithValue{
        TreeNode node;
        int val;
        NodeWithValue(TreeNode node, int val){
            this.node = node;
            this.val = val;
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<NodeWithValue> queue = new LinkedList<>();
        queue.add(new NodeWithValue(root, root.val));
        int sum = 0;
        while(!queue.isEmpty()){
            NodeWithValue n = queue.poll();
            TreeNode node = n.node;
            int val = n.val;
            if(node.left == null && node.right == null){
                sum += val;
            }
            if(node.left != null){
                queue.add(new NodeWithValue(node.left, (val << 1) + node.left.val));
            }
            if(node.right != null){
                queue.add(new NodeWithValue(node.right, (val << 1) + node.right.val));
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
