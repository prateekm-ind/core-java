package learn.multithreading.synchronizedExample;

import java.util.function.Consumer;

public class LambdaExample {

    public static void main(String[] args) {
        Consumer<String> consumer = (String data) -> {
            synchronized (LambdaExample.class){
                System.out.println("Hello Lambda inside synchronized block");
            }
        };
    }
}
