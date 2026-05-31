package com.dsa.tree;

import java.util.ArrayList;
import java.util.Stack;

class Node
{
    int data;
    Node left, right;
    Node(int item) {
        data = item;
        left = right = null;
    }
}
public class SpiralTraversalTree {

    public static ArrayList<Integer> findSpiral(Node root)
    {
        ArrayList<Integer> resList = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        boolean isEvenLevel = true;
        s1.push(root);
        while(!s1.isEmpty()){
            int size = s1.size();
            isEvenLevel = !isEvenLevel;
            for(int i=0; i< size; i++){
                Node node = s1.pop();
                resList.add(node.data);
                if(isEvenLevel){
                    if(node.left != null) s2.push(node.left);
                    if(node.right != null) s2.push(node.right);
                }else{
                    if(node.right != null) s2.push(node.right);
                    if(node.left != null)  s2.push(node.left);
                }
            }
            Stack<Node> temp = s1;
            s1 = s2;
            s2 = temp;

        }
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

        System.out.println(findSpiral(root));

    }

}
