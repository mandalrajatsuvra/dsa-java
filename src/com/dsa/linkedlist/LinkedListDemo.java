package com.dsa.linkedlist;

public class LinkedListDemo {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node convertArrayToLinkedList(int [] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1; i< arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = mover.next;
        }
        return head;
    }

    public static void printList(Node head){
        Node p1 = head;
        while (p1 != null){
            System.out.print(p1.data+ " ");
            p1 = p1.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int []arr = {1, 2, 3,4,5};
        Node head = convertArrayToLinkedList(arr);
        printList(head);
    }
}
