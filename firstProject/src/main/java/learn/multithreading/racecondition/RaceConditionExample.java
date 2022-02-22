package learn.multithreading.racecondition;

public class RaceConditionExample {
    NotAThreadSafeClass sharedInstance;

    public RaceConditionExample(NotAThreadSafeClass sharedInstance) {
        this.sharedInstance = sharedInstance;
    }

    Thread t1 = new Thread(new MyRunnable(this.sharedInstance));

    Thread t2 = new Thread(new MyRunnable(this.sharedInstance));
}

class MyRunnable implements Runnable{

    NotAThreadSafeClass instance;

    public MyRunnable(NotAThreadSafeClass instance) {
        this.instance = instance;
    }

    @Override
    public void run() {
        this.instance.add("Cristiano ");
    }
}
