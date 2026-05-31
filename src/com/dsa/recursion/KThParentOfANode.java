package com.dsa.recursion;

class Node{
    public int data;
    public Node left, right;
    public Node(int data) {
        this.data = data;
        this.left = null;this.right = null;
    }
}


public class KThParentOfANode {
    public static Node kthParentNode;
    public static void kthParentOfANode(Node root, int []k, int node){
        if(root == null) return;
        kthParentOfANode(root.left, k, node);
        kthParentOfANode(root.right, k, node);
        if(kthParentNode == null &&  root.data == node) {
            k[0]--;
            kthParentNode = root;
        }
        if(k[0] == 0){

        }
    }
    public static void main(String[] args) {
        kthParentNode = null;
    }

}
