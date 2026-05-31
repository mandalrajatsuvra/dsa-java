package com.dsa.recursion.backtracking;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class IsAdditiveNumber {

    public static boolean isValid(List<BigInteger> bigIntegers){
        if(bigIntegers.size() <= 2) return false;
        for(int i=2; i< bigIntegers.size(); i++){
            if(!bigIntegers.get(i).equals(bigIntegers.get(i-1).add(bigIntegers.get(i-2)))){
                return false;
            }
        }
        return true;
    }

    public static boolean f(String num, int index, List<BigInteger> res ){
        if(index == num.length()){
            System.out.println(res);
            return isValid(res);
        }
        for(int i=index+1; i<= num.length(); i++){
            String token = num.substring(index, i);
            if(token.charAt(0) == '0' && token.length() >= 2 ) continue;
            if(res.size()>=3 && !res.get(res.size()-1).equals(res.get(res.size()-2).add(res.get(res.size()-3)))) continue;
            res.add(new BigInteger(token));
            if(f(num, i, res)) return true;
            res.remove(res.size()-1);
        }
        return false;
    }
    public boolean isAdditiveNumber(String num) {

        return false;
    }

    public static void main(String[] args) {
        List<BigInteger> res = new ArrayList<>();
        System.out.println( f("112358", 0, res));
    }
}
