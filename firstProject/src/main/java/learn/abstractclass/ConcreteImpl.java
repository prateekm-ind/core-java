package learn.abstractclass;

public class ConcreteImpl extends AbstractClassExample{
    @Override
    public void exampleMethod() {
        System.out.println("Inside the example Method");
    }

    @Override
    void exampleDefaultMethod() {
        System.out.println("Inside the example default method");
    }

    private void callPrivateStaticMethod(){
        System.out.println("Calling private static method");

        //can access protected static method in the child class
        AbstractClassExample.exampleProtectedStatic();

        //can't access the private static method in the child class
        //will throw a compile-time error
        //AbstractClassExample.examplePrivateStatic();
    }
}
