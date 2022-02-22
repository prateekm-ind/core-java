package learn.queue;

/*
* Circular implementation of Queue data structure
*
* */
public class QueueImpl {
    int[] arr;
    int front;
    int capacity;
    int size;

    public QueueImpl(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.front = 0;
        this.size = 0;
    }

    public void enque(int x) {
        if (isFull()) return;
        int rear = getRear();
        rear = (rear + 1) % this.capacity;
        arr[rear] = x;
        size++;
    }

    private int getRear() {
        return (this.front + this.size - 1) % this.capacity;
    }

    public boolean isFull() {
        return (this.size % this.capacity) == 0;
    }

    public int deque() {
        int rear = getRear();
        rear = (rear + 1) % this.capacity;
        return arr[rear];
    }
}
