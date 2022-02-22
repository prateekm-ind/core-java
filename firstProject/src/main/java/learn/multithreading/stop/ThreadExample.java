package learn.multithreading.stop;

public class ThreadExample implements Runnable {

    private volatile boolean isTerminated = false;

    @Override
    public void run() {
        while (!isTerminated()) {
            try {
                Thread.sleep(1000);
                System.out.println("Inside the thread run() method...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isTerminated() {
        return isTerminated;
    }

    public void setTerminated(boolean terminated) {
        isTerminated = terminated;
    }
}
