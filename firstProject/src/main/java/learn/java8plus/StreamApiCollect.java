package learn.java8plus;

import learn.java8plus.db.StudentDatabase;
import learn.java8plus.db.domain.Student;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApiCollect {
    /*
     *   - Terminal operations
     *
     *   -   collect()
     *           - takes in input of type collector
     *           - produces result as per the input passed to the collect() method
     *           - accumulate the results until the streams are exhausted
     *   -  Collectors.<methodName>
     *   -   joining()
     *           - performs string concatenations
     *           - three different overloaded methods
     *   -   counting()
     *   -   mapping()
     *           - applies a transformation first and then collects the data
     *           - Collects data in a collection(of any type)
     *   -   maxBy(), minBy()
     *           - Comparator as an input parameter Optional as an o/p
     *           - maxBy() collector is used in conjunction with comparator returns max
     *           - minBy() collector is used in conjunction with comparator returns min
     *  -   summingInt()
     *           - returns the sum as a result int
     *  -   averagingInt()
     *           - returns the average as a result double
     *
     *  -   groupingBy()
     *          - equivalent to groupBy() in SQL
     *          - used to group elements based on the property
     *          - o/p is Map<K,V>
     *          - Three different versions
     *              - groupingBy(classifier)
     *              - groupingBy(classifier, downstream)
     *              - groupingBy(classifier, supplier)
     *  -   collectingAndThen()
     *          - collects the resultant o/p and then transforms it
     *  -   partitioningBy()
     *          - collector is also a kind of groupingBy()
     *          - partitioningBy() accepts a predicate as an input
     *          - return type Map<K,V> Map(Boolean, V)
     * */
    public static void main(String[] args) {
        /*
         *   Stream API
         *   joining()
         * */
        System.out.println("===joining()===");
        String joining01 = StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining());
        System.out.println(joining01);

        String joining02 = StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining("-"));
        System.out.println(joining02);

        String joining03 = StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining(",", "{(", ")}"));
        System.out.println(joining03);

        /*
         *   Stream API
         *   counting()
         * */
        System.out.println("===counting()===");
        Long collect = StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .distinct()
                .collect(Collectors.counting());

        System.out.println(collect);

        /*
         *   Stream API
         *   mapping()
         * */
        System.out.println("===mapping()===");
        Set<String> mapping = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName,
                        Collectors.toSet()));
        System.out.println(mapping);

//        var mapping02 = StudentDatabase.getAllStudents()
//                .stream()
//                .collect(Collectors.mapping(Student::getActivities,
//                        Collectors.joining()));
//        System.out.println(mapping);

        /*
         *   Stream API
         *   maxBy(), minBy()
         * */
        System.out.println("===maxBy(), minBy()===");
        Optional<Student> max = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
        Optional<Student> min = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));

        System.out.println(max);
        System.out.println(min);

        /*
         *   Stream API
         *   summingInt(), averagingInt()
         * */
        System.out.println("===summingInt(), averagingInt()===");

        int totalNotebooks = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.summingInt(Student::getNoteBooks));
        System.out.println(totalNotebooks);

        double averageNoOfNotebooks = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.averagingInt(Student::getNoteBooks));
        System.out.println(averageNoOfNotebooks);

        /*
         *   Stream API
         *   groupingBy()
         * */
        System.out.println("===groupingBy()===");
        var studentMap = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));
        System.out.println(studentMap);

        var customizedMap = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(s -> s.getGpa() > 3.9 ? "OUTSTANDING" : "AVERAGE"));

        System.out.println(customizedMap);

        Map<Integer, List<Student>> studentMap02 = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.toList()));
        System.out.println(studentMap02);

        Map<String, List<Double>> studentMap03 = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.mapping(Student::getGpa, Collectors.toList())));
        System.out.println(studentMap03);

        Map<String, String> studentMap04 = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.mapping(Student::getGender, Collectors.joining(","))));
        System.out.println(studentMap04);

        LinkedHashMap<String, List<Student>> hashMap = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getName, LinkedHashMap::new, Collectors.toList()));
        System.out.println(hashMap);

        var result = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)),
                                Optional::get)));

        System.out.println(result);

        /*
         *   Stream API
         *   partitioningBy()
         * */
        Predicate<Student> gpaPredicate = student -> student.getGpa() > 3.9;
        //returns Map<Boolean, Student> based on the gpaPredicate
        var resultantPartition = StudentDatabase.getAllStudents().stream()
                .collect(Collectors.partitioningBy(gpaPredicate));
        System.out.println(resultantPartition);

    }

}
