package com.chaytech.datastructure.queue;

/**
 * 普通顺序队列
 *
 * @author Chency
 * @email chaytech@163.com
 * @Date: 2019/06/22 15:28
 */
public class ArrayQueue {

    private int maxSize; // 队列最大长度
    private int front; // 队列头部指针
    private int rear; // 队列尾部指针
    private int[] items; // 存放队列数据的数组

    public ArrayQueue(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException();
        }
        this.maxSize = maxSize;
        this.front = -1; // 指向队列头部的前一个位置
        this.rear = -1; // 指向队列尾部最后一个数据位置
        this.items = new int[maxSize];
    }

    /**
     * 判断队列是否存储满了
     *
     * @return
     */
    public boolean isFull() {
        return rear == maxSize -1;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    public int size(){
        return rear - front;
    }

    /**
     * 往队列中添加数据
     *
     * @param object
     * @return
     */
    public boolean put(int object) {
        if (this.isFull()) {
            System.out.println("queue is full");
            return false;
        }

        this.items[++rear] = object;
        return true;
    }

    /**
     * 消费队列中的数据
     *
     * @return
     */
    public Object take() {
        if (this.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }

        int result = this.items[++front];
        this.items[front] = 0;
        return result;
    }

    /**
     * 打印队列中的数据
     */
    public void printQueue() {
        System.out.print("队首");
        for (int i = 0; i < this.maxSize; i++) {
            System.out.printf("[%d] ", items[i]);
        }
        System.out.println("队尾");
    }
}
