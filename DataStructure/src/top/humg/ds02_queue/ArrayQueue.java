package top.humg.ds02_queue;


public class ArrayQueue {
    private final int capacity;
    private int size;
    private int[] arr;
    private int addIdx = 0;
    private int removeIdx = 0;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    public boolean add(int val) {
        if (this.size == capacity) {
            return false;
        }
        size++;
        arr[addIdx] = val;
        addIdx = (addIdx + 1) % capacity;
        return true;
    }

    public int remove() {
        if (this.size == 0) {
            return -1;
        }

        int val = arr[removeIdx];
        arr[removeIdx] = 0;
        removeIdx = (removeIdx + 1) % capacity;
        size--;
        return val;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.add(1);
        queue.add(2);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.add(3);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
