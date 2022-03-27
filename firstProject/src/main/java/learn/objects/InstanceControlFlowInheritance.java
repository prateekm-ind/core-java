package learn.objects;

/*
* - Instance Control Flow
* - Identification of instance members from the Parent to child
* - Execution of instance variable assignments and instance block only in Parent class
* - Execution of parent class constructor
* - Execution of instance variable assignments and instance blocks in Child class
* - Execution of child class constructor
* */
public class InstanceControlFlowInheritance extends InstanceControlFlowExample{

    {
        System.out.println("Inside child class instance block");
    }

    public InstanceControlFlowInheritance() {
        System.out.println("Inside the child class constructor");
    }

    public static void main(String[] args) {
        System.out.println("Inside the main method of child class");

        InstanceControlFlowInheritance object = new InstanceControlFlowInheritance();
    }
}
