package learn.multithreading.locks;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithLocksExample {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void produce() throws InterruptedException {
        lock.lock();
        System.out.println("producer method");
        condition.await();
        System.out.println("Again back inside producer");
        //condition.awaitUntil(new Date());
        lock.unlock();
    }

    public void consume() throws InterruptedException {
        lock.lock();
        System.out.println("Inside consumer method");
        Thread.sleep(3000);
        condition.signal();
        //condition.signalAll();
        lock.unlock();
    }

    public static void main(String[] args) {
        ProducerConsumerWithLocksExample obj = new ProducerConsumerWithLocksExample();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.produce();
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.consume();
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
