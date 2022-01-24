package learn.java8plus;

/*
 *   Simplifies the lambda expression
 *
 *   ClassName :: instance-methodName
 *   ClassName :: static-methodName
 *   Instance :: methodName
 *
 *   Where to use the method reference?
 *   - where lambda expression is calling the in-built methods directly
 *   - where the Generic type <T> or <R> has in built method
 *   - only applicable if operation is to call the method and return
 *   - return should match the generic type returned
 *
 * */
public class MethodReferenceExample {
    public static void main(String[] args) {
        ExampleFunctionalInterface functionalInterface = System.out::println;
        functionalInterface.implementMethod("Method reference implementation");
    }
}
