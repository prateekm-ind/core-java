package learn.java8plus;

import java.util.function.Consumer;
import java.util.function.Supplier;

/*
 *   - Prior to java 7 if we have to use any variable inside the anonymous class
 *   declare the variables as final and then use it
 *   - After java 8 we don't declare the variables as final, but compiler makes them effectively final.
 * */
public class LambdaVariablesConstraints {
    public static void main(String[] args) {
        int i = 0;
        //lambda variables cannot have the same name as local variables
        /*
        Consumer<String> consumer = (i) -> {
            System.out.println("input :" + i);
        };*/

        Supplier<Integer> supplier = () -> {
            //this is not allowed
            // can't redeclare the same name variable inside lambda
            //int i=2;
            return 57;
        };

        //Effectively Final
        int value = 4;
        Consumer<Integer> integerConsumer = (n) -> {
            System.out.println("input: " + value);
            //Not allowed to modify any value that is referenced inside lambda
            //value++;
        };
        //this is also not possible as the value is used inside the lambda expression
        //value++;
    }
}
