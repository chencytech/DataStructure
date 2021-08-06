package com.chaytech.datastructure.queue;

import java.util.Scanner;

/**
 * @author Chency
 * @email chaytech@163.com
 * @Date: 2019/06/22 16:41
 */
public class TestCircleArrayQueue {

    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(5);
        Scanner scanner = new Scanner(System.in);//
        boolean flag = true;
        //输出一个菜单
        System.out.println("输入数据大于0：入队；小于0：出对；等于0：退出程序");
        while (flag) {
            int input = scanner.nextInt(); // 接收控制台输入数据
            if (input > 0) {
                queue.put(input);
                queue.printQueue();
            } else if (input < 0) {
                try {
                    Object value = queue.take();
                    System.out.printf("出队的元素是[%d]\n", value);
                    queue.printQueue();
                } catch (Exception e){
                    System.out.println("queue is empty");
                }
            } else {
                break;
            }
        }
    }
}
