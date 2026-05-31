package com.dsa.heap;


import java.util.*;

public class RearrangeKDistanceApart {

    public String rearrangeString(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            int prevFreq = freq.getOrDefault(c, 0);
            freq.put(c, prevFreq+1);
        }

        Comparator<Character> comparator = (c1,c2)-> freq.get(c2) - freq.get(c1);
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(comparator);
        for(char c: freq.keySet()){
            maxHeap.add(c);
        }
        String res = "";
        while (!maxHeap.isEmpty()){
            List<Character> poppedList = new ArrayList<>();
            for(int i=0; i< k && !maxHeap.isEmpty() ; i++){
                char c = maxHeap.poll();
                res += c;
                if(freq.get(c) > 1){
                    freq.put(c, freq.get(c)-1);
                    poppedList.add(c);
                }
            }
            for(char c: poppedList){
                maxHeap.add(c);
            }
            if(poppedList.size() == 1){
                char c = poppedList.get(0);
                if(freq.get(c) > 1){

                }
            }

        }
        return "";
    }
}
