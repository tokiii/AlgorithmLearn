package com.tokiii.learn;

import java.util.Scanner;

/**
 * 普通队列
 */
public class ArrayQueueTest {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头部数据");
            key = scanner.next().charAt(0); //接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = queue.headQueue();
                        System.out.printf("队列头的数据%d\n", head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }


}

class ArrayQueue {
    private int maxSize;// 最大容量
    private int front;  //队列头
    private int rear; //队列尾
    private int[] arr; //存放数据模拟队列

    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部 front是指向队列头的前一个位置
        rear = -1;  //指向队列尾部 rear是直接指向队列尾部
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满不能加入数据");
            return;
        }
        rear++; //让rear后移
        arr[rear] = n;
    }

    //获取队列数据，出队列
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()) {
            //通过抛出异常处理
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\t\n", i, arr[i]);
        }
    }

    //显示队列的头部
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空没有数据");
        }
        return arr[front + 1];
    }
}
