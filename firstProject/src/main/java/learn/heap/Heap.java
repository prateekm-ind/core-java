package learn.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * - Heaps are complete binary tree stored as an array
 * - Represented as an array or Dynamic array DS
 * - for a zero-indexed array it will be
 * - left[i] = 2i + 1
 * - right[i] = 2i + 2
 * - parent = (i-1)/2
 * - Binary tree filled from left to right without wasting any space
 *
 */
public abstract class Heap {
    protected List<Integer> list;
    //private int size;
    //private int capacity;

    public Heap(int val) {
        this.list = new ArrayList<>();
        list.add(val);
    }

    public abstract void insert(int val);

    public abstract void delete(int val);

    public static int left(int index) {
        return 2 * index + 1;
    }

    public static int right(int index) {
        return 2 * (index + 1);
    }

    public static int parent(int index) {
        return (index - 1) / 2;
    }

    public int size() {
        return this.list.size();
    }

    public List<Integer> getList() {
        return list;
    }

    public abstract void heapify(int val);
}
