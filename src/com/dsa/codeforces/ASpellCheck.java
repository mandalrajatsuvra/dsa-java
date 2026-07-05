package com.dsa.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class ASpellCheck {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();;
        String name = "Timur";
        char [] nameArray = name.toCharArray();
        Arrays.sort(nameArray);
        String sortedName = Arrays.toString(nameArray);
        for(int i=0; i < n; i++){
            int lenNext = sc.nextInt();
            String newName = sc.next();
            if(lenNext == 5){
                char [] newNameArray = newName.toCharArray();
                Arrays.sort(newNameArray);
                String sortedNewName = Arrays.toString(newNameArray);
                if(sortedNewName.equals(sortedName)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }else{
                System.out.println("NO");
            }
        }
    }
}
