package com.aeron.icoder.leetcode;

public interface List<E> {
    int size();

    boolean isEmpty();

    boolean contains(E element);

    E get(int index);

    E set(int index, E element);

    void add(E element);

    void add(int index, E element);

    E remove(int index);

    int indexOf(E element);

    void clear();
}
