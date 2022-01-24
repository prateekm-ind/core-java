package learn.java8plus;

public class LambdaExpressionExample {
    private ExampleFunctionalInterface exampleInterface = (input) -> {
        System.out.println("input :"+ input);
        System.out.println("Inside the implementation of implementMethod1()");
    };

    /*
     * in order to access class object inside the main method
     * create the object of the class inside the main and the use it to access
     * class's properties(fields) and behaviours(methods)
     * */
    public static void main(String[] args) {
        //possible because accessing the property inside the same class
        LambdaExpressionExample obj = new LambdaExpressionExample();
        obj.exampleInterface.implementMethod("Hello World");
    }

    public void method02(){
        System.out.println("Example public method");
    }
}
