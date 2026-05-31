package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStringWithoutAdjacentZeros {
    public void f(int n, int index, String pr, char prev, List<String> res ){
        if(index == n){
            res.add(pr);
            return;
        }
        if(index ==0 || prev == '1'){
            f(n, index+1, pr+ '0', '0', res);
            f(n, index+1, pr+'1', '1', res);
        }else{
            f(n, index+1, pr+'1', '1', res);
        }
    }

    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        f(n, 0, "", '#', res);
        return res;
    }

    public static void main(String[] args) {
        GenerateBinaryStringWithoutAdjacentZeros ob = new GenerateBinaryStringWithoutAdjacentZeros();
        List<String> res = ob.validStrings(2);
        System.out.println(res);

        List<String> res1 = ob.validStrings(3);
        System.out.println(res1);
    }
}
