package com.dsa.greedy;

public class GasStations {


    /*
    *
    *  gas = [1,2,3,4, 1, 3, 8,  5], cost = [3,4,5,1, 5, 2, 2, 2]
    *
    *      |+1+++++ |
    *      |        |
    *      |        |
    *      |+++++++|
    *
    *
    * */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = -1;
        int end = 0;
        int n = gas.length;
        int currentGasAmount=0;
        while(end < 2*n){
            int e = end%n;
            if(currentGasAmount + gas[e] >= cost[e]){
                if(start == -1) {
                    start = end;
                }else if(e == start){
                    return start;
                }
                currentGasAmount += gas[e];
                currentGasAmount -= cost[e];
            }else{
                start = -1;
                currentGasAmount = 0;
            }
            end++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(new GasStations().canCompleteCircuit(gas, cost));
    }
}
