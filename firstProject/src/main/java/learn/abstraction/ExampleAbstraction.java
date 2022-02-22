package learn.abstraction;

public class ExampleAbstraction {

    public static void main(String[] args) {
        //if we want to initialize an abstract class object we have to create
        //an anonymous concrete class implementation of that
        AbstractClassExample abstractClassExample = new AbstractClassExample() {
            @Override
            public void exampleMethod() {

            }

            @Override
            protected void exampleProtectedAbstractMethod() {

            }

            @Override
            void exampleDefaultMethod() {

            }
        };

        //concrete class initialization
        ConcreteImpl concreteClassRef = new ConcreteImpl();
        concreteClassRef.exampleMethod();

        //abstract class initialization
        AbstractClassWithoutAbstractMethod obj = new AbstractClassWithoutAbstractMethod() {
        };

        //only methods and variable available in AbstractClassExample
        //will be available for to the baseClassRef object here
        //methods specific to ConcreteImpl class will not be available
        //to the baseClassRef object
        //This statement means we refer to the implementation of ConcreteImpl class
        //for all the methods/property available in the AbstractClassExample class
        AbstractClassExample baseClassRef = new ConcreteImpl();

        //This statement means we refer to the implementation of ConcreteImpl class
        //for all the property and methods available in ExampleInterface interface
        ExampleInterface interfaceRef = new ConcreteImpl();
    }
}
