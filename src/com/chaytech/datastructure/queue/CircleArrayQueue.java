package com.chaytech.datastructure.queue;

/**
 * 循环顺序队列
 *
 * @author Chency
 * @email chaytech@163.com
 * @Date: 2019/06/22 21:36
 */
public class CircleArrayQueue {

    private int maxSize; // 队列最大长度
    private int front; // 队列头部指针
    private int rear; // 队列尾部指针
    private int[] items; // 存放队列数据的数组

    public CircleArrayQueue(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException();
        }
        this.maxSize = maxSize;
        this.items = new int[maxSize];
    }

    /**
     * 判断队列是否存储满了
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    public int size() {
        return (rear + this.maxSize - front) % this.maxSize;
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

        this.items[rear] = object;
        rear = (rear + 1) % this.maxSize;
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

        if (++front == this.maxSize) {
            front = 0;
        }
        int result = this.items[front];
        this.items[front] = 0;
        front = (front + 1) % this.maxSize;
        return result;
    }

    /**
     * 打印队列中的数据
     */
    public void printQueue() {
        System.out.print("队首");
        for (int i = front; i < front + this.size(); i++) {
            System.out.printf("[%d] ", items[i % this.maxSize]);
        }
        System.out.println("队尾");
    }
}
