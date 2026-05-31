package com.dsa.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListDemo {


    public static void main(String[] args) {
        /*List<Integer> integerList1 = Arrays.asList(1, 2,3);
        integerList1.add(5);
        System.out.println(integerList1);*/

        /*List<Integer> list = new ArrayList<>(2);
        list.set(0,1);
        list.set(1,2);
        System.out.println(list);*/


        List<Integer> list = Arrays.asList(new Integer[]{0,0,0,0});
        /*list.set(0, 1);
        list.set(1, 2);
        list.set(2, 3);
        list.set(3, 4);
        list.set(4, 5);*/
        System.out.println(list);


        List<Integer> resList = Collections.nCopies(5, 0);
        System.out.println(resList);

        Integer [] res = new Integer[resList.size()];
        List<Integer> resList2 = Arrays.asList(res);
        System.out.println(resList2);

        int [][] resArray = new int[5][5];
        System.out.println(Arrays.deepToString(resArray));

        ArrayList<Integer> resList3 = new ArrayList<>(Collections.nCopies(5, 0));
        resList3.set(0, 1);
        System.out.println(resList3);

        String s ="abx*";
        String[] sp = s.split("");
        System.out.println(sp);

        String s1= "";
        String[] sp1 = s1.split(",");
        System.out.println(Arrays.toString(sp1));

    }
}
