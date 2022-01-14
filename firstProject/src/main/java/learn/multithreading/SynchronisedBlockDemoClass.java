package learn.multithreading;

public class SynchronisedBlockDemoClass implements Runnable {
    public void objectLock() {
        System.out.println(Thread.currentThread().getName());
        //object level locking
        synchronized (this) {
            System.out.println("in block " + Thread.currentThread().getName());
            System.out.println("in block " + Thread.currentThread().getName() + " end");
        }
    }

    public void classLock() {
        System.out.println(Thread.currentThread().getName());
        // class level lock
        synchronized (SynchronisedBlockDemoClass.class) {
            System.out.println("in block " + Thread.currentThread().getName());
            System.out.println("in block " + Thread.currentThread().getName() + " end");
        }
    }

    @Override
    public void run() {
        objectLock();
    }
}
