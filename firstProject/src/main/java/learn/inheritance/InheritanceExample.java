package learn.inheritance;

public class InheritanceExample {
    public static void main(String[] args) {
        //Not possible in case of class that we can code to the base class
        //Class is not an interface
        //Reason : BaseClass in itself is a concrete implementation not an interface
        //BaseClass obj = new ChildClass();


        //Constructor Chaining :
        //whenever we call a child class that inherits from a base class
        //base class constructor will instantiate first
        //this is known to be as constructor chaining
        ChildClass childClassObj = new ChildClass();
        childClassObj.exampleMethod();
    }
}
