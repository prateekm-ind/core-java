package learn.java8plus;

/*
    - A functional interface must have one and only one abstract method
    that can be implemented as anonymous class or lambda expression
    - Not mandatory but useful in enforcing the mandate to have exactly
    one abstract interface
    - New functional interface introduced in java 8
    - Consumer
    - Predicate
    - Function
    - Supplier
    - BiConsumer
    - BiPredicate
    - BiFunction
    - UnaryOperator
    - BinaryOperator
 */
@FunctionalInterface
public interface ExampleFunctionalInterface {
    void implementMethod(String input);

    default boolean greaterThan(int a, int b) {
        return a > b;
    }

    //Compile time error as this will violate the functional interface conditions
    //void implementMethod2();
}
