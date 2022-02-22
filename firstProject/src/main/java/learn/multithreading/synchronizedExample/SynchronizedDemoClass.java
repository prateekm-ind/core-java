package learn.multithreading.synchronizedExample;

public class SynchronizedDemoClass extends Thread {
    String str;
    DisplayName d;

    public SynchronizedDemoClass(String str, DisplayName d) {
        this.str = str;
        this.d = d;
    }

    @Override
    public void run() {
        try {
            //d.getSyncString(str);
            d.getString(str);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
