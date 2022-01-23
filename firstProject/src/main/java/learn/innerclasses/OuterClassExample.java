package learn.innerclasses;

public class OuterClassExample {

    public class InnerClass {
        /*
        //can't define static methods inside the inner-class
        public static void staticMethod(){
            System.out.println("Inside inner class static method");
        }*/

        public void exampleMethod() {
            System.out.println("inside inner class example method");
        }
    }
}
