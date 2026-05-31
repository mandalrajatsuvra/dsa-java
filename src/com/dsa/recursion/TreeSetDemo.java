package com.dsa.recursion;

import com.sun.source.tree.Tree;

import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {


        TreeSet<int[]> treeSet = new TreeSet<>();
        treeSet.add(new int []{9});
        treeSet.add(new int[]{0});
        treeSet.add(new int[]{1, 4});

        System.out.println(treeSet);

    }
}
