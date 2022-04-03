package learn.heap;

public class Main {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(30);
        minHeap.insert(15);
        minHeap.insert(41);
        minHeap.insert(21);
        minHeap.insert(7);
        minHeap.insert(59);

        System.out.println(minHeap.getList());

        MaxHeap maxHeap = new MaxHeap(90);
        maxHeap.insert(40);
        maxHeap.insert(50);
        maxHeap.insert(60);
        maxHeap.insert(21);
        maxHeap.insert(100);
        maxHeap.insert(70);

        System.out.println(maxHeap.getList());
    }
}
