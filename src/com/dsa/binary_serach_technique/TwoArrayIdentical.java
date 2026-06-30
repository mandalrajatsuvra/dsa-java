package com.dsa.binary_serach_technique;

import java.util.HashMap;
import java.util.Map;

public class TwoArrayIdentical {


    public boolean isIdentical(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        for (int i = 0; i < b.length; i++) {
            if(!map.containsKey(b[i])) {
                return false;
            }
            if(map.get(b[i]) == 1) {
                map.remove(b[i]);
            }else {
                map.put(b[i], map.get(b[i]) - 1);
            }
        }
        return map.size() == 0;
    }

    public static void main(String[] args) {

    }
}
