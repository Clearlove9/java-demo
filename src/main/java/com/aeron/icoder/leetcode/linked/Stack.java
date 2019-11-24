package com.aeron.icoder.leetcode.linked;

import java.util.ArrayList;
import java.util.List;

public class Stack<E> {
    private List<E> list;

    public Stack(List<E> list) {
        if (list == null) {
            this.list = new ArrayList<>();
        } else {
            this.list = list;
        }
    }

    public Stack() {
        list = new ArrayList<>();
    }

    public void push(E element) {
        list.add(element);
    }

    public E pop() {
        return list.remove(list.size() - 1);
    }

    public E peek() {
        return list.get(list.size() - 1);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

}
