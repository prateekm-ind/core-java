package learn.objects;

/*
* - While creating any new object in java JVM creates a new instance flow
* - Instance Flow will include the following sequence of execution
*   -   Identification of instance member from top to bottom
*   -   Execution of instance variable assignments and instance blocks from top to bottom
*   -   Execution of constructor
* */
public class InstanceControlFlowExample {

    private String str = "String variable 01";

    {
        methodOne();
        System.out.println("Inside the first instance block of base class");
    }

    public InstanceControlFlowExample(String str) {
        this.str = str;
    }

    public InstanceControlFlowExample() {
        System.out.println("Inside the constructor of base class");
    }

    public void methodOne() {
        System.out.println("Inside the methodOne() of base class");
    }

    public static void main(String[] args) {
        System.out.println("Inside the main method line 01");
        InstanceControlFlowExample obj = new InstanceControlFlowExample();
        System.out.println("Inside the main method line 02");
        obj.methodTwo();
        System.out.println("Inside the main method line 03");
    }

    public void methodTwo(){
        System.out.println("Inside the methodTwo()");
    }
}
