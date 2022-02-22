package learn.multithreading;

import learn.multithreading.synchronizedExample.DisplayName;
import learn.multithreading.synchronizedExample.SynchronizedDemoClass;

public class MyThread extends Thread{
    public MyThread() {
        super.start();
        System.out.println("Inside the MyThread no argument constructor");
    }

    public MyThread(Runnable target) {
        super(target);
        System.out.println("Inside the MyThread Runnable arg constructor");
    }

    public static void main(String[] args) throws Exception {
        Runnable myRunnable = ()->{
            System.out.println("Hello World");
        };
        MyThread myThread = new MyThread(myRunnable);
        myThread.start();

        //synchronised vs normal execution
        DisplayName d = new DisplayName("Gd mrng");
        Thread synchronizedDemoClass01 = new SynchronizedDemoClass("Ironman", d);
        Thread synchronizedDemoClass02 = new SynchronizedDemoClass("Doctor-Strange", d);

        synchronizedDemoClass01.start();
        synchronizedDemoClass02.start();

        //synchronised demo ends


    }
}
