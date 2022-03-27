package learn.objects;

/*
*   -   Identification of static members from top to bottom
*   -   All static variables are identified in this step
*   -   Execution of static variables, assignments and static block from top to bottom
*   -   Finally, the static main method is executed in the last step of the static control flow
*   -
* */
public class StaticControlFlow {

    protected final static String NAME = "Hello There";

    /*  - initialization block
    *   - Will only be called if new instance of StaticControlFlow class is created
    * */
    {
        System.out.println("Inside the initialization block");
    }

    /*
    * - Class level block will be called once the class is compiled
    *
    * */
    static {
        System.out.println("inside the static block 01");
    }

    //will be called after all the static blocks are called
    public static void main(String[] args) {
        System.out.println(NAME);
        System.out.println("Inside the psvm");
    }

    static {
        System.out.println("inside the static block 02");
    }
}
