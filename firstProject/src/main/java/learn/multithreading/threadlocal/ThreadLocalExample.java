package learn.multithreading.threadlocal;

import java.util.Optional;

public class ThreadLocalExample {
    private static ThreadLocal<UserDetails> threadLocal = new ThreadLocal<>();

    private static ThreadLocal<UserDetails> threadLocalNull = new ThreadLocal<>();

    private static ThreadLocal<Optional<UserDetails>> optionalThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        UserDetails bethaBenz = new UserDetails("Betha Benz", 41, 'F');
        threadLocal.set(bethaBenz);
        System.out.println("threadlocal .get() " + threadLocal.get().getName());
        System.out.println("Thread local Betha Benz");
        System.out.println( threadLocal == null);


        System.out.println("Thread local null :");
        System.out.println("Thread local null obj:" + threadLocalNull);
        System.out.println( threadLocalNull.get() == null);
        UserDetails scarlettWitch = new UserDetails("Scarlett Witch",28 ,'F');
        threadLocalNull.set(scarlettWitch);
        System.out.println("Thread local null :");
        System.out.println(threadLocal.get() == null);


        threadLocalNull.remove();
        System.out.println(threadLocalNull);

        System.out.println("Optional of thread local : ");
        System.out.println(optionalThreadLocal.get());

    }
}
