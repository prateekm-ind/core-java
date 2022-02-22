package learn.singleton;

public class ImplClass {

    //private static ThreadLocal<SingletonPerThread> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        SingletonPerThread singleton = SingletonPerThread.getInstance();
        singleton.setName("Prateek");

        //threadLocal.set(singleton);

        //SingletonPerThread singleton1 = threadLocal.get();
        System.out.println("singleton in main: "+ singleton);
        singleton.setName("Aakash");
        System.out.println("Thread local: " + singleton.getName());
        //System.out.println("Thread local: " + threadLocal.get());
        //System.out.println("Thread local: " + threadLocal.get());



        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonPerThread singleton1 = SingletonPerThread.getInstance();
                System.out.println("singleton in t1: "+ singleton1);
                System.out.println("t1: "+ singleton1.getName());
                singleton1.setName("Shantanu");
                System.out.println("t2: "+ singleton1.getName());
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonPerThread singleton1 = SingletonPerThread.getInstance();
                System.out.println("singleton in t2: "+ singleton1);
                System.out.println("t2: "+ singleton1.getName());
            }
        });
        t2.start();
    }
}
