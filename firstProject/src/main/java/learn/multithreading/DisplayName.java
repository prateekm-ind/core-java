package learn.multithreading;

public class DisplayName {
    String str;

    public DisplayName(String str) {
        this.str = str;
    }

    public synchronized void getSyncString(String s) throws InterruptedException {
        int i = 0;
        //System.out.println(this.str);

        while (i < 7) {
            Thread.sleep(1000);
            System.out.println(s + " " + this.str);
            i++;
        }
    }

    public void getString(String s) throws InterruptedException {
        int i = 0;
        //System.out.println(this.str);

        while (i < 7) {
            Thread.sleep(1000);
            System.out.println(s + "" + this.str);
            i++;
        }
    }
}
