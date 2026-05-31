package com.dsa.linkedlist;


class ListNode{
    int key;
    int value;
    ListNode left;
    ListNode right;
    public ListNode(int key, int value){
        this.key = key;
        this.value = value;
        this.left=null;
        this.right = null;
    }
}

class DoublyLinkedList{
    ListNode head;
    ListNode tail;
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }
    public void addFirst(ListNode node){
        if(head == null || tail == null){
            head = node;
            tail = node;
        }else{
            node.right = head;
            head.left = node;
            head = node;
        }
    }
    public ListNode pollLast(){
        if(tail == null || head == null) return null;
        if(head == tail){
            ListNode node = tail;
            head = null;
            tail = null;
            return node;
        }else{
            ListNode node = tail;
            ListNode prev = tail.left;
            prev.right = null;
            tail.left = null;
            tail = prev;
            return node;
        }
    }
    public ListNode deleteNode(ListNode node){
        if(head == null || tail == null ) return null;
        if(head == tail && head == node){
            ListNode temp = head;
            head = null;
            tail = null;
            return temp;
        } else if(head == node){
            ListNode temp = head;
            ListNode next = head.right;
            head.right = null;
            next.left = null;
            head = next;
            return temp;
        }else if(tail == node){
            ListNode temp = tail;
            ListNode prev = tail.left;
            tail.left = null;
            prev.right = null;
            tail = prev;
            return temp;
        }else{
            ListNode temp = node;
            ListNode prev = node.left;
            ListNode next = node.right;
            prev.right = next;
            next.left = prev;
            return temp;
        }
    }
}

public class LRUCache {


    public static void main(String[] args) {
        ListNode n1 = new ListNode(10, 10);
        ListNode n4 = new ListNode(20, 20);
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addFirst(n1);
        doublyLinkedList.addFirst(n4);


        ListNode node1 = doublyLinkedList.deleteNode(n4);
        System.out.println(node1.value);
        ListNode node2 = doublyLinkedList.deleteNode(n1);
        System.out.println(node2.value);

        ListNode node3 = doublyLinkedList.deleteNode(n4);
        System.out.println(node3);





        //ListNode n2 = doublyLinkedList.pollLast();
        //System.out.println(n2.value);
        //ListNode n3 = doublyLinkedList.pollLast();
        //System.out.println(n3.value);

    }
}
