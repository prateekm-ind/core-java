package learn.queue;

public class DequeImpl {
    private int size;
    private int cap;
    private int[] arr;

    public DequeImpl(int cap) {
        this.cap = cap;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }
}
