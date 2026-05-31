package com.dsa.heap;


import java.util.PriorityQueue;

/*You have given a nested json which has a key k1 and k1 can repeat any. level give me this list of k1 values
*
* { k1:{
*       k1:{
*
*
*       }
*   },
*  k1:{
*
*
*   }
*}
*
*
*
*
*
*
* */
public class Test {

    public static void main(String[] args) {
        String s = "abc";

        System.out.println(s.substring(0, s.length() -1));
        System.out.println(s.substring(1));

        PriorityQueue<String> minHeap  = new PriorityQueue<>();
        minHeap.add("7599");
        minHeap.add("9579");
        minHeap.poll();
        System.out.println(minHeap);


    }

}
