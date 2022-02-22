package learn.multithreading.synchronizedExample;

public class ExampleOnHowToDealWithDrawbackOfSynchronization {

    private int counter1 = 0;
    private int counter2 = 0;

    private final Object lock01 = new Object();
    private final Object lock02 = new Object();

    public void increment1() {
        synchronized (lock01) {
            counter1 += 100;
        }
    }

    public void increment2() {
        synchronized (lock02) {
            counter2 += 100;
        }
    }
}
