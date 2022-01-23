package learn.innerclasses;

public class ImplementationClass {
    public static void main(String[] args) {
        /*
        * Advantages :
        * Shows a special type of relationship. Inner class exist iff the outer class exist
        *
        * Ability to access all the data members of main class including private
        *
        * provides easier code because it logically groups classes and interfaces in only one place
        *
        * code optimization
        *
        * provides encapsulation
        * inner classes can be defined as private
        *
        *
        * */


        OuterClassExample outer = new OuterClassExample();
        OuterClassExample.InnerClass inner = new OuterClassExample().new InnerClass();
    }
}
