package learn.multithreading.racecondition;

public class NotAThreadSafeClass {
    StringBuilder stringBuilder = new StringBuilder();

    public void add(String s){
        this.stringBuilder.append(s);
        System.out.println(" "+ this.stringBuilder);
    }
}
