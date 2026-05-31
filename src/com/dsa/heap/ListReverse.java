package com.dsa.heap;
import  static java.lang.System.*;

/*
 Given a linked list, write a function to reverse every k nodes (where k is an input to the function).

        Example:


        Input: 1->2->3->4->5->6->7->8->NULL, K = 3

        Output: 3->2->1->6->5->4->8->7->NULL

        Input: 1->2->3->4->5->6->7->8->NULL, K = 5

        Output: 5->4->3->2->1->8->7->6->NULL*/

import java.util.Arrays;
import java.util.Stack;

class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
        this.next = null;
    }
}
public class ListReverse {



    static {


        int x = 10;
        System.out.println(x);
    }
    public static Node reverseList(Node head, int k){
        //Arrays.parallelPrefix();
        //Arrays.cop
        Node temp = head;
        Node dHead = new Node(Integer.MIN_VALUE);
        Node res = dHead;
        while (temp != null){
            int pos = 0;
            Stack<Node> stack = new Stack<>();
            while (pos < k && temp != null){
                stack.push(temp);
                temp = temp.next;
                pos++;
            }
            while (!stack.isEmpty()){
                Node node = stack.pop();
                node.next = null;
                res.next = node;
                res = res.next;
            }
        }
        return dHead.next;
    }

    public static void main(String[] args) {
        double data = 444.324;
        out.println(10*20 + "ABC" + 10*20);

    }
}
