package com.dsa.core;

import java.util.*;

public class PrecedenceAndAssociativity {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        int result = a + b * 2; // Multiplication has higher precedence than addition
        System.out.println("Result of a + b * 2: " + result); //

        int array[] = {1, 2, 3, 4, 5};
        int arr2[]= {6, 7, 8, 9, 10};
        array[0] = arr2[0]  = 10;
        System.out.println("First element of array: " + array[0]); // Output: 10
        System.out.println("First element of arr2: " + arr2[0]); //

        int i = 1;
        int j = 2;

        int sum = ++i + ++j; // Pre-increment i, then use j's value before incrementing it
        System.out.println("Value of sum: " + sum); // Output: 4

        int x = 5;
        int y = 10;

        if(x == y >> 1){
            System.out.println("x is equal to y right shifted by 1");
        } else {
            System.out.println("x is not equal to y right shifted by 1");
        }
        x = 1;
        if(x == y & 1==1){
            System.out.println("x is equal to y AND 1");
        } else {
            System.out.println("x is not equal to y AND 1");
        }
        x = 1;
        do{
            System.out.println("x is: " + x);
            x ++;
        }while (x <= 10 );
        System.out.println("Final value of x: " + x); // Output: 11

        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(10);
        deque.addFirst(20);
        deque.addFirst(30);
        System.out.println("First element in deque: " + deque.poll());

        // Output:
        String s = "Hello, World!";
        String subString = s.substring(0, 5); // Extracts "Hello"
        System.out.println("Substring: " + subString); // Output: Hello
        System.out.println(s.substring(1));

        System.out.println(Character.isDigit('2'));
        System.out.println(Character.isDigit('A'));
        System.out.println(Character.isLowerCase('A'));
        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.isUpperCase('A'));
        System.out.println(Character.isUpperCase('1'));
        i = 0;
        while(++i < 4){
            System.out.println("i is: " + i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("Queue elements:" + queue.peek());

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);

        TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("TreeMap elements:"+ treeMap.entrySet());


        int t = 10 >> 1 >> 1;
        int t1 = 10 << 1 >> 2;
        System.out.println("Value of t after right shift: " + t); // Output: 5
        System.out.println("Value of t1 after left and right shift: " + t1); // Output: 2

        int t3 = ~0;
        System.out.println("Value of t3 after bitwise NOT: " + t3); // Output: -1

        int t4 = 10 & 5; // Bitwise AND
        System.out.println(t4);

        boolean t5 = (10 & 5) == 0;
        System.out.println(t5);

        boolean t6 =  false || true && false || true;
        System.out.println("Value of t6 after logical operations: " + t6); // Output: true
        boolean t7 = true || false && false;
        System.out.println("Value of t7 after logical operations: " + t7); //

        Deque<Integer> stack = new LinkedList<>();
        //stack.pop();

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("One");
        linkedHashSet.add("Two");
        linkedHashSet.add("Three");
        linkedHashSet.add("One");
        System.out.println("LinkedHashSet elements: " + linkedHashSet);
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('b');
        hs.add('c');
        hs.remove('a');
        System.out.println("HashSet elements: " + hs);

    }
}
