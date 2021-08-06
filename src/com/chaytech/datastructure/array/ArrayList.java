package com.chaytech.datastructure.array;

import com.chaytech.datastructure.List;

/**
 * 动态数组
 *
 * @author Chency
 * @email chaytech@163.com
 * @Date 2021/06/06 19:57
 */
public class ArrayList<E> implements List<E> {

    // 默认容量
    private static final int DEFAULT_CAPACITY = 10;
    // 数组长度
    private int size;
    // 数组元素
    private Object[] elements;

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        if (capacity <= 0) {
            elements = new Object[DEFAULT_CAPACITY];
        } else {
            elements = new Object[capacity];
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public void add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size);
        }

        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);

        ensureCapacity(size + 1);
        E oldValue = (E) elements[index];
        elements[index] = element;
        return oldValue;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E oldValue = get(index);
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }

        elements[--size] = null;
        return oldValue;
    }

    @Override
    public int indexOf(Object element) {
        if (element == null) {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        // 销毁数组中的元素
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(elements[i]);
        }

        sb.append(']');
        return sb.toString();
    }

    /**
     * 保证数组容量
     *
     * @param capacity 所需容量
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        // 需要扩容
        if (capacity > oldCapacity) {
            // 新的容量为旧容量的1.5倍
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            Object[] newElements = new Object[newCapacity];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size);
        }
    }
}
