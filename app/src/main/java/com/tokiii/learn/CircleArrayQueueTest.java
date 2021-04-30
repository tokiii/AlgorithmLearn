package com.tokiii.learn;

import java.util.Scanner;

/**
 * 环形队列实现
 * front 和 rear  头部和尾部
 */
public class CircleArrayQueueTest {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(3);
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

class CircleArrayQueue {
    private int maxSize;// 最大容量
    private int front;  //队列头
    private int rear; //队列尾
    private int[] arr; //存放数据模拟队列

    public CircleArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0; //指向队列头部
        rear = 0;  //指向队列后一个元素
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
        rear = (rear + 1) % maxSize; //当添加数据时，rear 后移一个位置，保证rear指向最后一个元素的后一个位置

    }

    //获取队列数据，出队列
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()) {
            //通过抛出异常处理
            throw new RuntimeException("队列空，不能取数据");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;// 取完数据，front也往后移动
        return value;
    }

    //显示队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        // (rear + maxSize - front) % maxSize 计算有效数据 初始值是front 然后 小于front+ 有效数据遍历  i%maxsize是真实的下标
        // 可以这么理解  当front > rear 时 证明有效数据是rear - front   当front < rear 时 证明 rear 走了循环 rear + maxSize - front 是真实的个数  取余只是个算法可以把这两种情况合并， 都是舍弃一个 maxSize
        for (int i = front; i < front + (rear + maxSize - front) % maxSize; i++) {
            System.out.printf("arr[%d]=%d\t\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //显示队列的头部
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空没有数据");
        }
        return arr[front];
    }
}
