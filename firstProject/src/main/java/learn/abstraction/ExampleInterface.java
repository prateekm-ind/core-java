package learn.abstraction;

public interface ExampleInterface {

    /*
    *   By interfaces we can achieve 100% abstraction
    * */

    /*
    * unlike classes interfaces doesn't have their own constructor
    ExampleAbstraction(){

    }*/

    // all methods by default are defined as
    // public abstract
    public abstract void method1();

    //this is also public and abstract by default
    void method2();
}
