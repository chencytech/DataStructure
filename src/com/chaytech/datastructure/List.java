package com.chaytech.datastructure;

/**
 * 数组接口
 *
 * @author Chency
 * @email chaytech@163.com
 * @Date 2021/06/06 20:01
 */
public interface List<E> {

    int size();

    boolean isEmpty();

    boolean contains(Object object);

    void add(E object);

    void add(int index, E element);

    E get(int index);

    E set(int index, E element);

    E remove(int index);

    int indexOf(E element);

    void clear();
}
