package learn.abstraction;

public class ConcreteImpl extends AbstractClassExample implements ExampleInterface {

    public ConcreteImpl() {
        System.out.println("Concrete class constructor");
    }

    @Override
    public void exampleMethod() {
        System.out.println("Inside the example Method");
    }

    @Override
    protected void exampleProtectedAbstractMethod() {
        System.out.println("inside protected method");
    }

    @Override
    void exampleDefaultMethod() {
        System.out.println("Inside the example default method");
    }

    private void callPrivateStaticMethod() {
        System.out.println("Calling private static method");

        //can access protected static method in the child class
        AbstractClassExample.exampleProtectedStatic();

        /*  can't access the private static method in the child class
        *   will throw a compile-time error
        */
        //AbstractClassExample.examplePrivateStatic();
    }

    @Override
    public void method1() {
        //add impl
    }

    @Override
    public void method2() {
        //add impl
    }
}
