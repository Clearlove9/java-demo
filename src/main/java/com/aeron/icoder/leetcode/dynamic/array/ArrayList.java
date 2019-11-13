package com.aeron.icoder.leetcode.dynamic.array;

import com.aeron.icoder.leetcode.List;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {
    //这个肯定是要有的，动态数组，有未放元素的空间
    private int size;
    private Object[] elementData;//对象地址

    private final static int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        if (capacity > 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        } else if (capacity == 0) {
            elementData = new Object[0];
        } else {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
    }

    @Override
    public int size() {
        return size;
//        return elementData.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            //return null;
            throw new IndexOutOfBoundsException("invalid index of the list.");
        }

        return (E) elementData[index];
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            //return null;
            throw new IndexOutOfBoundsException("invalid index of the list.");
        }

        Object old = elementData[index];
        elementData[index] = element;

        return (E) old;
    }

    @Override
    public void add(E element) {
        /*if (size == elementData.length) {
            //扩容
            Object[] tmp = new Object[size * 2];
            for (int i = 0; i < elementData.length; i++) {
                tmp[i] = elementData[i];
            }

            tmp[size++] = element;
            elementData = tmp;
            return;
        }

        elementData[size++] = element;*/

        add(size, element);
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            //return null;
            throw new IndexOutOfBoundsException("invalid index of the list.");
        }

        /*if (size == elementData.length) {
            //扩容
            Object[] tmp = new Object[size * 2];
            for (int i = 0; i < elementData.length; i++) {
                if (i < index) {
                    tmp[i] = elementData[i];
                    continue;
                }

                if (i == index) {
                    tmp[i] = element;
                    continue;
                }

                tmp[i + 1] = elementData[i];
            }

            elementData = tmp;
            size++;
            return;
        }*/

        ensureCapacity(size + 1);

        for (int i = size - 1; i >= index; i--) {
            elementData[i + 1] = elementData[i];
        }

        elementData[index] = element;
        size++;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elementData.length;

        if (oldCapacity >= capacity) {
            return;
        }

        int newCapacity = oldCapacity + (oldCapacity >> 1);
        Object[] tmp = new Object[newCapacity];

        for (int i = 0; /*i < elementData.length*/ i < size; i++) {
            tmp[i] = elementData[i];
        }

        elementData = tmp;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            //return null;
            throw new IndexOutOfBoundsException("invalid index of the list.");
        }

        Object old = elementData[index];

        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }

        elementData[--size] = null;
        return (E) old;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elementData[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public void clear() {
        //clear之后可能会重复利用，所以数组对象不要销毁 - 可以循环利用的留下，不能循环利用的丢弃
        //elementData = empty_array;

        //gc收集  -  重要
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }

        size = 0;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "size=" + size +
                ", elementData=" + Arrays.toString(elementData) +
                '}';
    }
}
