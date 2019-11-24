package com.aeron.icoder;

import com.aeron.icoder.leetcode.linked.LinkedList;
import com.aeron.icoder.leetcode.linked.Stack;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<>();
//        System.out.println(list);
//
//        list.add(1);
//        System.out.println(list);
//        list.add(2);
//        list.add(3);
//        list.add(5);
//        list.add(6);
//        System.out.println(list);
//        list.add(3, 4);
//        System.out.println(list);
//
//        System.out.println(list.get(0));
//        System.out.println(list.get(5));
//
//        list.set(0, 0);
//        list.set(1, 1);
//        list.set(5, 10);
//        System.out.println(list);
//
//        // 0,1,3,4,5,10
//        list.remove(0);
//        list.remove(1);
//        list.remove(3);
//
//        //1,4,5
//        System.out.println(list);
//        System.out.println(list.size());

        Stack<Character> stack = new Stack<>();
        stack.push('1');
        stack.push('2');
        stack.push('3');
        stack.push('4');

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
