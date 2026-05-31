package com.dsa.collections;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {


        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(10);
        deque.addFirst(20);
        deque.addFirst(30);
        deque.add(50);
        deque.addLast(60);
        System.out.println(deque.peekFirst());
        System.out.println(deque);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(1);
        minHeap.add(-10);
        System.out.println(minHeap.poll()); 
        System.out.println(minHeap);

         Character.isLowerCase('A');

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(4);
        System.out.println(priorityQueue.poll());

        System.out.println("======================================TREE SET=====================================");
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(-2);
        treeSet.add(3);
        treeSet.add(-8);
        treeSet.add(5);
        System.out.println(treeSet);
        System.out.println(treeSet.pollFirst());
        System.out.println(treeSet);





    }
}
