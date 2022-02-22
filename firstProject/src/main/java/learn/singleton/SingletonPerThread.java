package learn.singleton;

public class SingletonPerThread {

    private static SingletonPerThread singleton;

    private ThreadLocal<String> name = new ThreadLocal<>();


    private SingletonPerThread() {
    }

    public static SingletonPerThread getInstance() {
        if (singleton == null) {
            return new SingletonPerThread();
        }
        return singleton;
    }

    void setName(String name) {
        this.name.set(name);
    }

    public String getName() {
        return this.name.get();
    }
}
