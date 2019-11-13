package com.aeron.icoder.leetcode.linked;

import com.aeron.icoder.leetcode.List;

import java.util.Objects;

public class SingleLinkedList<E> implements List<E> {
    private int size;
    private Node<E> first;

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
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);

        Node<E> node = node(index);
        E result = node.element;
        node.element = element;

        return result;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public void add(int index, E element) {
        checkIndexForAdd(index);

        /*Node<E> newNode = new Node<>(element, null);

        if (index == 0) {
            newNode.next = first;
            first = newNode;
            size++;
            return;
        }

        Node<E> preNode = node(index - 1);
        newNode.next = preNode.next;
        preNode.next = newNode;
        size++;*/

        if (index == 0) {
            first = new Node<>(element, first);
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }

        size++;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        /*if (index == 0) {
            E e = first.element;
            first = first.next;
            size--;
            return e;
        }

        Node<E> prev = node(index - 1);
        Node<E> curr = prev.next;
        E element = curr.element;
        prev.next = curr.next;
        size--;

        return element;*/

        Node<E> node = first;
        if (index == 0) {
            first = first.next;
        } else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
        }

        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> tmp = first;

        int index = 0;
        while (tmp != null) {
            if (Objects.equals(element, tmp.element)) {
                return index;
            }

            tmp = tmp.next;
            index++;
        }
        return -1;
    }

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    private Node<E> node(int index) {
        checkIndex(index);
        Node<E> tmp = first;
        while (index > 0) {
            tmp = tmp.next;
            index--;
        }

        return tmp;
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("invalid index of the list.");
        }
    }

    private void checkIndexForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("invalid index of the list for add.");
        }
    }

    private final static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
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
    }
}
