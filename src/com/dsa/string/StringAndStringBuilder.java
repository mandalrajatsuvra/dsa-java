package com.dsa.string;

public class StringAndStringBuilder {


    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("Hello");
        System.out.println(s.charAt(0));

        s.setCharAt(0, 'D');

        s.insert(2,'E');
        s.deleteCharAt(0);

        System.out.println(s);

    }
}
