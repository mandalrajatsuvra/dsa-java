package com.dsa.recursion.backtracking;

import java.util.Arrays;
import java.util.List;

public class ConstructLexicographicallyLargestNumber {


    public boolean solve(int pos ,int n, int [] res, boolean [] visited){
        if(pos == res.length){
            return true;
        }

        if(res[pos] !=0){
            return solve(pos+1,n,res,visited);
        }

        for(int i=n; i>=1; i--){
            if(i==1 && !visited[i] && res[pos] == 0){
                visited[i] = true;
                res[pos] = i;
                if(solve(pos+1, n, res, visited)){
                    return true;
                }
                res[pos] = 0;
                visited[i] = false;
            }else if(!visited[i] && res[pos] == 0  && pos +i < 2*n-1 && res[pos+i] == 0){
                visited[i] = true;
                res[pos] = i;
                res[pos+i] = i;
                if(solve(pos+1, n, res, visited)){ return  true;}
                res[pos] = 0;
                res[pos+i] = 0;
                visited[i] = false;
            }
        }
        return false;
    }



    public boolean solve(int pos,  int n, List<Integer> in, List<Integer> pr, int [][]visited ) {
        if(pos == n){
            if(pr.size() == n){
                return true;
            }
            return false;
        }else if(pos > pr.size()) return false;
        for(int i=0; i < n; i++){
            int x = in.get(i);
            if(x == 1 && visited[x][0] ==-1 && visited[x][1] ==-1){
                visited[x][0] = 1;
                visited[x][1] = 1;
                pr.add(x);
                if(solve(pos+1,n,in,pr,visited)) return true;
                visited[x][0] = -1;
                visited[x][1] = -1;
                pr.remove(pr.size()-1);
            }else if(visited[x][0] == -1){
                visited[x][0] = pos;
                pr.add(x);
                if(solve(pos+1, n, in, pr, visited)) return true;
                visited[x][0] = -1;
                pr.remove(pr.size()-1);
            }else if(visited[x][1] == -1 && Math.abs(pos - visited[x][0])== x){
                visited[x][1] = pos;
                pr.add(x);
                if(solve(pos+1, n, in, pr, visited)) return true;
                visited[x][1] = -1;
                pr.remove(pr.size()-1);
            }else{
               if(solve(pos+1, n, in, pr, visited)) return true;
            }
        }
        return false;
    }
    public int[] constructDistancedSequence(int n) {
        /*int [][] visited = new int[n+1][2];
        List<Integer> in = new ArrayList<>();
        for(int i = n; i >= 2; i--){
            in.add(i);
            in.add(i);
        }
        in.add(1);
        for(int [] e: visited){
            Arrays.fill(e,-1);
        }
        List<Integer> pr = new ArrayList<>();
        solve(0, in.size(), in, pr, visited);
        int [] arr = new int[pr.size()];
        for(int i = 0; i < pr.size(); i++){
            arr[i] = pr.get(i);
        }
        return arr;*/

        int []res = new int[2*n-1];
        boolean [] visited = new boolean[n+1];
        solve(0,n,res,visited);
        return res;

    }

    public static void main(String[] args) {
        ConstructLexicographicallyLargestNumber  lc = new ConstructLexicographicallyLargestNumber();
        System.out.println( Arrays.toString(lc.constructDistancedSequence(15)));
    }
}
