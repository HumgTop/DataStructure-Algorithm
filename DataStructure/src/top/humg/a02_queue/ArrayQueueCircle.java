package top.humg.a02_queue;


public class ArrayQueueCircle {
    public static void main(String[] args) {
        CircleArray queue = new CircleArray(4);
        queue.addQueue(11);
        queue.addQueue(13);
        queue.addQueue(15);

        queue.show();

        System.out.println(queue.getQueue());
        queue.show();
        queue.addQueue(17);
        queue.show();
        System.out.println(queue.getQueue());
        queue.show();
        queue.addQueue(19);
        queue.show();
    }

    static class CircleArray {
        private int maxSize;
        private int front;
        private int rear;//指向队列中最后一个元素的后一个位置
        private int[] arr;//该数组用于模拟队列

        //构造方法，用于初始化队列
        public CircleArray(int maxSize) {
            this.maxSize = maxSize;
            arr = new int[maxSize];
            front = 0;
            rear = 0;
        }

        //判断队列空间是否已满
        public boolean isFull() {
            return (rear + 1) % maxSize == front;
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
                arr[rear] = n;
                rear = (rear + 1) % maxSize;//如果rear已经指向数组的最后一位，则其加一后对maxSize取模=0。rear重新指向数组首位，完成环形数组
                System.out.printf("数据：%d 已存入队列中%n", n);
            }
        }

        //数据出队列
        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空");
            } else {
                int result = arr[front];
                front = (front + 1) % maxSize;
                return result;
            }
        }

        public void show() {
            if (isEmpty()) {
                System.out.println("队列为空，无数据");
                return;
            }

            //从front开始，遍历size()次
            for (int i = front; i < front + size(); i++) {
                System.out.printf("%d\t", arr[i % maxSize]);
            }
            System.out.println();
        }

        public int size() {
            return (rear + maxSize - front) % maxSize;//队列中存储的有效数据
        }
    }
}
