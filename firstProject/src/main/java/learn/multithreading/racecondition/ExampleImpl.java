package learn.multithreading.racecondition;

public class ExampleImpl {

    public static void main(String[] args) {
        NotAThreadSafeClass instance = new NotAThreadSafeClass();
        RaceConditionExample raceConditionExample = new RaceConditionExample(instance);
        raceConditionExample.t1.start();
        raceConditionExample.t2.start();
    }
}
