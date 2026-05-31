package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinate {

    /*
    *
    * Example 1:
        Input: s = "(123)"
        Output: ["(1, 2.3)","(1, 23)","(1.2, 3)","(12, 3)"]
        Example 2:

        Input: s = "(0123)"
        Output: ["(0, 1.23)","(0, 12.3)","(0, 123)","(0.1, 2.3)","(0.1, 23)","(0.12, 3)"]
        Explanation: 0.0, 00, 0001 or 00.01 are not allowed.
        Example 3:

        Input: s = "(00011)"
        Output: ["(0, 0.011)","(0.001, 1)"]
    *
    *
    *
    * */

    public void solve(int pos, String s, boolean isSpaceUsed, String pr, List<String> res) {
        /*if(pos == s.length()){
            if(isSpaceUsed){
                res.add(pr);
            }
            return;
        }
        if(pos == 0){
            solve(pos+1, s, isSpaceUsed,pr+ "(", res);
        }else if(pos >= 1 && pos < s.length()-1){
            if(!isSpaceUsed) {
                solve(pos + 1, s, true, pr + s.charAt(pos) + ", ", res);
                solve(pos + 1, s, isSpaceUsed, pr + s.charAt(pos), res);
            }else{
                solve(pos + 1, s, isSpaceUsed, pr + s.charAt(pos), res);
            }
        }else{
            solve(pos+1, s, isSpaceUsed, pr+")", res);
        }*/

        for(int i=pos+1; i<s.length(); i++){


        }



    }
    public List<String> ambiguousCoordinates(String s) {
        List<String> res = new ArrayList<>();
        solve(0, s, false, "", res);
        return res;
    }

    public static void main(String[] args) {
        AmbiguousCoordinate a = new AmbiguousCoordinate();
        System.out.println(a.ambiguousCoordinates("(123)"));
    }
}
