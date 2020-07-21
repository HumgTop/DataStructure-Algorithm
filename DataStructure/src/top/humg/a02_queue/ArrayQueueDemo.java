package top.humg.a02_queue;


import java.util.Arrays;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        queue.addQueue(11);
        queue.addQueue(13);
        queue.addQueue(15);

        queue.show();

        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());

    }

     static class ArrayQueue {
        private int maxSize;
        private int front;
        private int rear;
        private int[] arr;//该数组用于模拟队列

        //构造方法，用于初始化队列
        public ArrayQueue(int maxSize) {
            this.maxSize = maxSize;
            arr = new int[maxSize];
            front = -1;
            rear = -1;
        }

        //判断队列空间是否已满
        public boolean isFull() {
            return rear == maxSize - 1;
        }

        //判断队列是否为空
        public boolean isEmpty() {
            return front == rear;
        }

        //添加数据到队列
        public void addQueue(int n) {
            if (isFull()) {
                System.out.println("队列空间已满");
            } else {
                rear++;
                arr[rear] = n;
                System.out.printf("数据：%d 已存入队列中%n", n);
            }
        }

        //数据出队列
        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空");
            } else {
                front++;
                return arr[front];
            }
        }

        public void show() {
            if (isEmpty()) {
                System.out.println("队列为空，无数据");
                return;
            }

            System.out.println(Arrays.toString(arr));
        }
    }
}
