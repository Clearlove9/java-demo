package com.aeron.icoder.leetcode.linked;

import com.aeron.icoder.leetcode.List;

import java.util.Objects;

public class LinkedList<E> implements List<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    @Override
    public int size() {
        return size;
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
        checkIndex(index);
        return node(index).getElement();
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        Node<E> node = node(index);
        E tmp = node.element;
        node.element = element;
        return tmp;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public void add(int index, E element) {
        checkIndexForAdd(index);

       /* if (index == 0) {
            Node<E> node = new Node<>(element, null, first);

            if (size > 0) {
                first.prev = node;
            } else {
                last = node;
                first = node;
            }
        } else {
            Node<E> node = node(index - 1);
            node.next = new Node<>(element, node, node.next);
        }*/


        if (index == size) {
            Node<E> oldLast = last;
            last = new Node<>(element, oldLast, null);
            if (oldLast == null) {
                first = last;
            } else {
                oldLast.next = last;
            }
        } else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(element, prev, next);
            if (prev == null) {
                first = node;
            } else {
                prev.next = node;
            }
            next.prev = node;
        }

        size++;
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index error");
        }
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        Node<E> node;
        if (index == 0) {
            node = first;
            first = node.next;
            if (first != null) {
                first.prev = null;
            }
        } else if (index == size - 1) {
            node = last;
            last = node.prev;
            last.next = null;
        } else {
            node = node(index);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(element, node.element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;

        //源码中需要遍历设置为0，因为iterator有引用
    }

    private Node<E> node(int index) {
        Node<E> x;

        if (index < (size << 1)) {
            //从头遍历
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            //从尾遍历
            x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
        }

        return x;
    }

    private boolean isListElement(int index) {
        return index >= 0 && index < size;
    }

    private void checkIndex(int index) {
        if (!isListElement(index)) {
            throw new IndexOutOfBoundsException("index error");
        }
    }

    private final static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(E element, Node prev, Node next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("LinkedList{");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            sb.append(node.element).append(",");

            if (i == size - 1) {
                sb.deleteCharAt(sb.length() - 1);
            }

            node = node.next;
        }

        sb.append("}");
        return sb.toString();
    }
}
