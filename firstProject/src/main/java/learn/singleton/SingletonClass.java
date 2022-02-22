package learn.singleton;

public class SingletonClass {

    private static SingletonClass singleton;

    private String name;


    private SingletonClass(String name) {
        this.name = name;
    }

    public static SingletonClass getInstance(String name) {
        synchronized (SingletonClass.class) {
            if (singleton == null) {
                return new SingletonClass(name);
            }
            return singleton;
        }
    }

    public String getName() {
        return this.name;
    }
}
