package learn.java8plus;

import java.util.ArrayList;
import java.util.List;

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

        List<String> stringList = new ArrayList<>();
        ExampleFunctionalInterface exampleFunctionalInterface = (s)-> stringList.add(s);

        exampleFunctionalInterface.implementMethod("BGIM");
        System.out.println("StringList : "+ stringList);

        //static method inside the ExampleFunctionalInterface
        var isEqual = ExampleFunctionalInterface.equalsTo(10, 20);
        System.out.println(isEqual);
    }

    public void method02(){
        System.out.println("Example public method");
    }
}

class ImplementExampleInterface implements ExampleFunctionalInterface{

    @Override
    public void implementMethod(String input) {
        System.out.println("ThoughtWorker");
    }
}