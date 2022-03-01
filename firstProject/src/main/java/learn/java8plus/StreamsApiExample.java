package learn.java8plus;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsApiExample {


    public static void main(String[] args) {
        /*
         *   Collections vs Streams
         *   Collections :
         *   -   Can add or modify at any point of time
         *   -   Elements in the collection can be accessed in any order
         *   -   Collections are eagerly constructed
         *
         *   Streams
         *   -   Can't add or modify the elements in the streams
         *   -   Fixed data set
         *   -   Elements in the stream can be accessed only in sequence
         *   -   Streams are lazily constructed (will be invoked once the
         *  terminal operations are invoked)
         *
         * */
        List<String> names = new ArrayList<>();
        names.add("Alex");
        names.add("Buffon");
        names.add("Cristiano");
        names.add("Jadon");

        names.remove("Buffon");

        System.out.println(names);

        //No such method exists for streams
        //Can't modify collections with streams
        //names.stream().add()
        //names.stream().remove();



        /*
         *   Collections
         *   -   Collections can be traversed any number of time
         *
         *   Streams
         *   -   Can be iterated once
         *
         *
         *
         * */
        for (String name : names) {
            System.out.println(name);
        }

        for (String name : names) {
            System.out.println(name);
        }

        Stream<String> namesStream = names.stream();
        namesStream.forEach(System.out::println);

        //this will throw an  IllegalStateException
        // : streams has already been operated
        //namesStream.forEach(System.out::println);


        /*
         *   Collections
         *   -   Performs external iterations to iterate through elements
         *   Streams
         *   -   Performs internal iterations to iterate through elements
         *
         * */
    }

}
