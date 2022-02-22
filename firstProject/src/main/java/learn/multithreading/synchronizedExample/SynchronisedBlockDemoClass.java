package learn.multithreading.synchronizedExample;

public class SynchronisedBlockDemoClass implements Runnable {
    //  should be done only for the non-static block or method
    //  multiple objects can be created
    public void objectLock() {
        System.out.println(Thread.currentThread().getName());
        //object level locking
        synchronized (this) {
            System.out.println("in block " + Thread.currentThread().getName());
            System.out.println("in block " + Thread.currentThread().getName() + " end");
        }
    }


    //  class level locking should only be done for the
    //  static methods or blocks or objects
    //  reason : static block pr methods have class level access
    //      thus only one instance is generated in the JVM
    //      i.e for the one class level object
    public static void classLock() {
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
