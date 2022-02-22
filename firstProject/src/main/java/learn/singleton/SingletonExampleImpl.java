package learn.singleton;

public class SingletonExampleImpl {

    public static void main(String[] args) throws InterruptedException {
        SingletonClass singletonClass = SingletonClass.getInstance("1+");
        System.out.println("singleton : "+ singletonClass);
        System.out.println("singleton class : "+ singletonClass.getName());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                SingletonClass singletonClass1 = SingletonClass.getInstance("Apple");
                System.out.println("singleton1 : " + singletonClass1);
                System.out.println("singleton : " + singletonClass1.getName());
            }
        });
        t1.start();
        t1.join();
        Thread.sleep(1000);
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonClass singletonClass2 = SingletonClass.getInstance("Dell");
                System.out.println("singleotn2 : " + singletonClass2);
                System.out.println("singleton " + singletonClass2.getName());
            }
        });
        t2.start();
        t2.join();

        //will throw an illegalStateException:
        //t1.start();
        t1.join();

        SingletonClass singletonClass03 = SingletonClass.getInstance("Samsung");
        System.out.println("singleton03 "+ singletonClass03);
        System.out.println("singleton :"+ singletonClass.getName());
    }
}
