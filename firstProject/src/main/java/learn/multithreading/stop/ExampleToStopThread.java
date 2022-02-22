package learn.multithreading.stop;

public class ExampleToStopThread {
    /*
    *   After java 8 the thread.stop() method is deprecated
    *   Reason: the threads are not terminated properly
    *
    *   In order to terminate thread use the following execution@
    *
    * */
    public static void main(String[] args) throws InterruptedException {
        ThreadExample threadExample = new ThreadExample();
        //threadExample.setTerminated(false);
        Thread thread = new Thread(threadExample);
        thread.start();
        Thread.sleep(2000);

        //thread.join(); // will go into infinite loop

        threadExample.setTerminated(true);

    }
}
