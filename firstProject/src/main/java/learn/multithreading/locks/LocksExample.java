package learn.multithreading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 *   Reentrant lock
 *   -   It has same behaviour as the "synchronized approach"
 *   -   it has some additional feature
 *   -   the ReentrantLock can be based on the fairness parameter
 *   -   fairness parameter will reduce the thread starvation
 * */
public class LocksExample {
    private int counter = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        /*
         *   Start block
         * */
        lock.lock();
        for (int i = 0; i < 1000; i++) {
            counter++;
        }
        lock.unlock();
        /*
         *   End block
         *
         *   Here in this case if there occurs any exception in-between the
         *   start lock.lock() and end lock.unlock()
         *   the lock.unlock() method will not be called and hence the program
         *   will end up in a deadlock situation
         *
         *   this is why always use try-catch-finally block
         *   and call the finally unlock inside the finally block
         * */
    }

    public void incrementWithTryCatchFinally() {
        lock.lock();
        try {
            for (int i = 0; i < 1000; i++) {
                counter++;
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LocksExample locksExample = new LocksExample();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                locksExample.increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                locksExample.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(locksExample.counter);
    }
}
