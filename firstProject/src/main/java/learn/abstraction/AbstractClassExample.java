package learn.abstraction;

//can exist without adding any abstract method
public abstract class AbstractClassExample {

    //Unlike interface Abstract class do have constructors
    //their constructor will be called first before their concrete impl class
    //each time a new object of concrete class is created
    public AbstractClassExample() {
        System.out.println("Abstract class constructor called");
    }

    //need to be overridden in the base class
    public abstract void exampleMethod();

    private void examplePrivateMethod() {
        System.out.println("inside private method of abstract class");
    }

    //abstract methods can not be declared as private or default - compile time error
    //must be public
    //private abstract void examplePrivateAbstractMethod();

    //can be protected
    protected abstract void exampleProtectedAbstractMethod();

    //public by default
    abstract void exampleDefaultMethod();

    //cannot make abstract method static
    //abstract static void exampleStaticMethod();

    //can't be called in the child class
    //only available here inside this class
    private static void examplePrivateStatic() {
        System.out.println("inside private static method");
    }

    //can be called in the child classes
    //because this is a static it belongs to class not to object
    //this method can be directly called with class name
    protected static void exampleProtectedStatic() {
        System.out.println("inside protected static method");
    }

}
