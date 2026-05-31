package com.dsa.linkedlist;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Node{
    int data;
    Node left, right;
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class LinkedList{
    Node head;
    Node tail;
    public LinkedList(){
        head = null;
        tail = null;
    }
    public void addElementAtFirst(Node node){
        if(head == null || tail == null){
            head = node;
            tail = node;
        }else{
            node.right = head;
            head.left = node;
            head = node;
        }
    }
    public void deleteNode(Node node){
        if(node == null) return;
        if(head == tail && head == node){
            head = null;
            tail = null;
        }
        if(node == head){
            Node next = node.right;
            next.left =null;
            head.right= null;
            head =  next;
        }else if(node == tail){
            Node prev = node.left;
            prev.right = null;
            tail.left = null;
            tail = prev;
        }else{
            Node prev = node.left;
            Node next = node.right;
            prev.right = next;
            next.left = prev;
        }
    }
    public void addElementAtLast(Node node){
        if(head == null || tail == null){
            head = node;
            tail = node;
        }else{
            tail.right = node;
            node.left = tail;
            tail = tail.right;
        }
    }
    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
        System.out.println();
    }
    public Node removeElementAtLast(){
        if(head == null || tail == null){
            return null;
        }else if(head == tail){
            Node node = head;
            head = null;
            tail = null;
            return node;
        }else {
            Node node = tail;
            Node prev = tail.left;
            tail = prev;
            prev.right = null;
            node.left = null;
            return node;
        }
    }
}


public class ImplementDoublyLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);

        linkedList.addElementAtFirst(n1);
        linkedList.addElementAtFirst(n2);
        linkedList.addElementAtFirst(n3);
        linkedList.addElementAtFirst(n4);
        linkedList.addElementAtFirst(n5);

        linkedList.printList();

        linkedList.deleteNode(n5);

        linkedList.printList();


        /*Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque = new java.util.LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);


        deque.remove(3);*/




        /*Node node = linkedList.removeElementAtLast();
        System.out.println(node.data);
        node = linkedList.removeElementAtLast();
        System.out.println(node.data);
        node = linkedList.removeElementAtLast();
        System.out.println(node.data);
        node = linkedList.removeElementAtLast();
        System.out.println(node.data);
        node = linkedList.removeElementAtLast();
        System.out.println(node.data);

        System.out.println(linkedList.removeElementAtLast());*/


        //linkedList.printList();

    }
}
