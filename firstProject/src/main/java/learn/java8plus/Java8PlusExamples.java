package learn.java8plus;

import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 *   Simplified the concurrency operations
 *   Introduced functional features such as Lambdas, Streams, Optional etc.
 *   Functional Programming :
 *   - Embraces creating immutable objects
 *   - Enables you to code in pure functions
 *   - Embraces methods as first class citizen
 *   - More concise and readable code
 *
 * */
public class Java8PlusExamples {
    /*
     *   Functional vs imperative style of programming
     * - Imperative
     * - Focuses on how to perform operations
     * - Embraces object immutability
     * - list the step-by-step instructions on how to achieve an objective
     * - we write code on what needs to be done at each step
     * - Uses classical OOPs
     *
     * - Functional/ Declarative
     * - Focuses on what result you want
     * - Embraces object immutability
     * - Uses the functions that are already part of the library to achieve an objective
     * */

    public static void main(String[] args) {
        LambdaExpressionExample lambdaExpressionExample = new LambdaExpressionExample();
        lambdaExpressionExample.method02();

        /*
         * Consumer interface accept method
         * */
        Consumer<String> consumer = (input) -> {
            System.out.println("Inside consumer's accept Method");
            System.out.println("input :" + input);
            return;
        };

        consumer.accept("Web Scalability");

        /*
         * Predicate interface test method
         * */
        Predicate<Integer> predicate = (input) -> {
            System.out.println("inside predicate's test method");
            if (input > 10) return true;
            return false;
        };

        predicate.test(11);

        /*
         * Function interface apply method
         * */
        Function<String, String> functionalInterface = (input) -> {
            System.out.println("inside function's apply method");
            return input.toUpperCase(Locale.ROOT);
        };

        System.out.println(functionalInterface.apply("Keep Pushing"));


        Supplier<String> stringSupplier = () -> {
            System.out.println("inside supplier's get method");
            return "Hello World";
        };

        System.out.println(stringSupplier.get());
    }
}
