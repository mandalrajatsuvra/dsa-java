package com.dsa.recursion.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Node{
    public int data;
    public Node left, right;
    public Node(int data){
        this.data = data;
        this.left = null; this.right = null;
    }
}

class NodeWithFindStatus{
    public Node node;
    public boolean isPresent;
    public NodeWithFindStatus(Node node, boolean isPresent){
        this.node = node;
        this.isPresent = isPresent;
    }
}

public class TreeTraversal {

    public static NodeWithFindStatus findParentHelper(Node root, int data){
        if(root == null) return new NodeWithFindStatus(null, false);

        NodeWithFindStatus left = findParentHelper(root.left, data);
        NodeWithFindStatus rigth = findParentHelper(root.right, data);
        NodeWithFindStatus rootStatus = new NodeWithFindStatus(null, false);
        if(left.isPresent || rigth.isPresent){
            rootStatus.isPresent = true;
        }
        if(root.data == data){
            rootStatus.node = root;
        }
        return rootStatus;
    }
    public static Node findParentNode(Node root, int data){
        Node parent = null;
        NodeWithFindStatus status = findParentHelper(root, data);
        return status.node;
    }
    public static void rootToLeafUsingInorderTraversal(Node root, LinkedList<Integer> pr, List<List<Integer>> resList){
        if(root == null) return;
        //pr.add(root.data);
        if(root.left == null && root.right == null){
            resList.add(new ArrayList<>(pr));
        }
        rootToLeafUsingInorderTraversal(root.left, pr, resList);
        rootToLeafUsingInorderTraversal(root.right, pr, resList);
        pr.removeLast();
    }
    private static void createParentDictionary(Node root, Node parent, HashMap<Node, Node> dict){
        if(root == null) return;
        dict.put(root, parent);
        createParentDictionary(root.left, root, dict);
        createParentDictionary(root.right, root, dict);
    }
    private static Node findNode(Node root, int node){
        if(root == null ) return null;
        if(root.data == node){
            return root;
        }
        Node left = findNode(root.left, node);
        if(left != null) return left;
        return findNode(root.right, node);
    }

    private static Node kthAncestor = null;
    public static boolean findKthAncestor2(Node root, int k[], int target){
        if(root == null) return false;
        if(root.data == target){
            return true;
        }
        boolean left = findKthAncestor2(root.left, k , target);
        if(left){
            k[0] --;
            if(kthAncestor == null && k[0] == 0){
                kthAncestor = root;
            }
            return true;
        }
        boolean right = findKthAncestor2(root.right, k, target);
        if(right){
            k[0] --;
            if(kthAncestor == null && k[0] == 0){
                kthAncestor = root;
            }
            return true;
        }
        return false;
    }

    public static Node findKthAncestor(Node root, int k, int target){
        Node node = findNode(root, target);
        if(node == null) return node;
        HashMap<Node, Node> dict = new HashMap<>();
        createParentDictionary(root, null, dict);
        while (--k > 0 && node != null){
            node = dict.get(node);
        }
        return node;
    }
    public static void leftView(Node root, List<Integer> res){
        if(root == null) return;
        res.add(root.data);
        if(root.left != null){
            leftView(root.left, res);
        }else{
            leftView(root.right, res);
        }
    }

    public static void maximumNode(Node root, int [] max){
        if(root == null) return;
        maximumNode(root.left, max);
        max[0] = Math.max(max[0], root.data);
        maximumNode(root.right, max);
    }
    public static void rootToLeafSum(Node root, int s, boolean[] res){
         if (root == null){
             if(!res[0]) res[0] = s == 0;
             return;
         }
         s -= root.data;
         rootToLeafSum(root.left,  s, res);
         rootToLeafSum(root.right, s, res);
         s += root.data;
    }
    public static void rootToLeafPath(Node root, LinkedList<Integer> pr, List<List<Integer>> res){
        if(root == null) {
            return;
        }
        pr.add(root.data);
        if(root.left == null && root.right == null){
            res.add(new ArrayList<>(pr));
        }
        rootToLeafPath(root.left, pr, res);
        rootToLeafPath(root.right, pr, res);
        pr.removeLast();
    }
    public static void preorderTraverse(Node root, List<Integer> res){
        if(root == null) return;
        res.add(root.data);
        preorderTraverse(root.left, res);
        preorderTraverse(root.right, res);
    }
    public static void inorderTraverse(Node root, List<Integer> res){
        if(root != null) return;
        inorderTraverse(root.left, res);
        res.add(root.data);
        inorderTraverse(root.right, res);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.right = new Node(90);

        // maxNode
        /*int [] max = {Integer.MIN_VALUE};
        maximumNode(root, max);
        System.out.println(max[0]);*/
        //List<List<Integer>> resList = new ArrayList<>();
        /*List<Integer> res = new ArrayList<>();
        leftView(root, res);
        System.out.println(res);*/


        /*Node node = findKthAncestor(root, 3,7);
        if(node != null) System.out.println(node.data);*/

        // 2nd case

        /*List<List<Integer>> resList = new ArrayList<>();
        rootToLeafUsingInorderTraversal(root, new LinkedList<>(), resList);
        System.out.println(resList);*/

        System.out.println(findParentNode(root, 90).data);

    }
}
