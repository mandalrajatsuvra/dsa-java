package com.dsa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode previous = null;
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null ||  !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if(root.right == null ||  root.right == previous){
                res.add(root.data);
                stack.pop();
                previous = root;
                root = null;
            }else{
                root = root.right;
            }
        }
        return res;
    }
}
