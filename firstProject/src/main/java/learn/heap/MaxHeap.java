package learn.heap;

public class MaxHeap extends Heap {
    public MaxHeap(int val) {
        super(val);
    }

    @Override
    public void insert(int val) {
        list.add(val);
        int size = this.size();
        int i = size - 1;
        while (i != 0 && list.get(parent(i)) < list.get(i)) {
            int temp = list.get(i);
            list.remove(i);
            list.add(i, list.get(parent(i)));
            list.remove(parent(i));
            list.add(parent(i), temp);
            i = parent(i);
        }
    }

    @Override
    public void delete(int val) {

    }

    @Override
    public void heapify(int val) {

    }
}
