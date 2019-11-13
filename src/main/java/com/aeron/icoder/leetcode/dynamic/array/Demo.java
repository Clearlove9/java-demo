package com.aeron.icoder.leetcode.dynamic.array;

import com.aeron.icoder.leetcode.List;

public class Demo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(0,11);

        list.remove(0);
        list.remove(1);
    }
}
