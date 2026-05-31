package com.dsa.linkedlist;

import java.util.LinkedList;

public class MyHashMap {

    LinkedList<int[]> [] map;

    public MyHashMap() {
        this.map = new LinkedList[10000];
        for(int i=0; i< 10000; i++){
            this.map[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int updatedKey = key % 10000;
        LinkedList<int[]> list = map[updatedKey];
        for(int i=0; i< list.size(); i++){
            int [] node = list.get(i);
            if(node[0] == key){
                list.remove(i);
                list.addFirst(new int[]{key, value});
            }
        }
    }

    public int get(int key) {
        int updatedKey = key % 10000;
        LinkedList<int []> list = map[updatedKey];
        for(int i=0; i< list.size(); i++){
            int [] node = list.get(i);
            if(node[0] == key){
                return node[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        int updatedKey = key % 10000;
        LinkedList<int[]> list = map[updatedKey];
        for(int i=0; i< list.size(); i++){
            int [] node = list.get(i);
            if(node[0] == key){
                list.remove(i);
            }
        }
    }
}
