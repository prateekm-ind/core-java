package learn.java8plus;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/*
 *   Numeric Stream - Represent the primitive values in a Stream
 *       -   IntStream
 *       -   LongStream
 *       -   DoubleStream
 *   Advantage : save an unnecessary operation of unboxing wrapper class to primitive type
 * */
public class StreamApiNumeric {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(6, 1, 4, 2, 7, 8, 4, 9, 3, 0);

        //unboxing operations occurs to unwrap into Integer
        var resultList = integers.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(resultList);

        /*
         *   Stream API
         *   IntStream
         * */

        System.out.println("===IntStream===");
        //sum() -> equivalent to reduce(0, Integer::sum)
        var sum = IntStream.rangeClosed(0, 10).sum();

        System.out.println(sum);

        /*
         *   Stream API
         *   IntStream - range() vs rangeClosed()
         * */
        System.out.println("===IntStream range() vs rangeClosed()===");
        System.out.println(IntStream.range(0, 10).max());
        System.out.println(IntStream.rangeClosed(0, 10).max());

        /*
         *   Stream API
         *   LongStream - range() vs rangeClosed()
         * */
        System.out.println("===LongStream range() vs rangeClosed()===");
        System.out.println("===LongStream range()===");
        LongStream.range(0, 27).forEach(x -> System.out.print(x + ","));
        System.out.println("\n===LongStream rangeClosed()===");
        LongStream.rangeClosed(0, 27).forEach(y -> System.out.print(y + ","));

        /*
         *   Stream API
         *   LongStream to DoubleStream
         * */
        System.out.println("\n===LongStream to DoubleStream===");
        LongStream.rangeClosed(0,10)
                .asDoubleStream()
                .forEach(x-> System.out.print(x+", "));

        /*
         *   Stream API
         *   Aggregate functions sum(), min(), max(), average()
         * */
        System.out.println("\n===Aggregate function===");
        int sumOfFirstFifty = IntStream.rangeClosed(1,50).sum();
        System.out.println(sumOfFirstFifty);

        OptionalInt optionalInt = IntStream.rangeClosed(50,50).max();
        System.out.println(optionalInt);

        OptionalDouble optionalDouble = LongStream.rangeClosed(1,50).average();
        System.out.println(optionalDouble);

        /*
         *   Stream API
         *   Boxing, Unboxing of Numeric Streams
         * */
        System.out.println("===Numeric Stream boxing===");
        List<Integer> integerList = IntStream.range(0,10)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(integerList);

        integerList.stream()
                .mapToInt(Integer::intValue)
                .forEach(x-> System.out.print(x+", "));


    }


}
