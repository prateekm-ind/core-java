package learn.java8plus;

import learn.java8plus.db.StudentDatabase;
import learn.java8plus.db.domain.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiPractice {

    /*
    *   Stream Api
    *   - Not all stream operations are stateful
    *   - doesn't maintain any state although operations are stateful
    *   Intermediate Operations
    *   -   Stateful functions
    *           -   distinct()
    *           -   sorted()
    *           -   skip()
    *           -   limit()
    *   -   Stateless functions
    *           -   map()
    *           -   filter()
    *
    *   -   ShortCircuit Operations
    *           -   limit()
    *           -   findFirst()
    *           -   findAny()
    *           -   anyMatch()
    *           -   allMatch()
    *           -   noneMatch()
    *   -
    *
    * */
    public static void main(String[] args) {
        List<Student> list = StudentDatabase.getAllStudents();

        //print out all the students using streams
        list.stream().forEach(System.out::println);

        Stream studentStream = list.stream();
        System.out.println(studentStream.count());


        /*
         *   Stream API
         *   map()
         * */
        //Filter the studentsStream, then converts the type T to U
        // and collect the List<String>
        List<String> filteredList = list.stream()
                .filter(s -> s.getGpa() > 3.5)
                .map(Student::getName)
                .collect(Collectors.toList());//collect List<String>

        filteredList.stream().forEach(System.out::println);


        //Converts one type T to another type U
        list.stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .forEach(System.out::println);


        /*
         *   Stream API
         *   flatmap()
         * */
        System.out.println("===without flatmap(List::stream)===");
        var students = list.stream()
                .map(Student::getActivities)
                .collect(Collectors.toList());

        students.stream().forEach(System.out::println);

        System.out.println("===with flatmap(List::stream)===");
        var studentList = list.stream()
                .map(Student::getActivities)
                .flatMap(List::stream) //Stream<String>
                .collect(Collectors.toList());

        studentList.stream().forEach(System.out::println);

        System.out.println("===Activity Map===");
        //Convert a list to map using stream API
        var activityMap = list.stream()
                .collect(Collectors.toMap(Student::getName, Student::getActivities));

        System.out.println(activityMap.toString());

        System.out.println("===activityMap entrySet===");
        activityMap.entrySet().stream()
                .forEach(System.out::println);

        /*
         *   Stream API
         *   distinct(), count()
         * */
        System.out.println("===using distinct()===");
        list.stream().map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .forEach(System.out::println);

        System.out.println("===count()===");
        var noOfDistinctActivities = list.stream().map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();

        System.out.println(noOfDistinctActivities);


        /*
         *   Stream API
         *   sorted(), sorted(Comparator.comparing())
         * */
        //using in-built sorted of stream-API
        System.out.println("===sorted()===");
        list.stream().map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        //using Comparator with stream-API
        System.out.println("===sorted() with comparator===");
        list.stream()
                .sorted(Comparator.comparing(Student::getGpa)) //Here passing the function in comparator
                .forEach(System.out::println);

        System.out.println("===sorted() with comparator in reverse===");
        list.stream().sorted(Comparator.comparing(Student::getGradeLevel).reversed()) //here sorting based on gradeLevel()
                .forEach(System.out::println);


        /*
         *   Stream API
         *   filter()
         * */
        System.out.println("===filter()===");

        list.stream().filter(s -> s.getGender().equals("female"))
                .map(Student::getName)
                .forEach(System.out::println);

        list.stream().map(Student::getGender)
                .filter(s -> s.equals("male"))
                .forEach(System.out::println);


        /*
         *   Stream API
         *   reduce()
         * */
        System.out.println("===reduce()===");
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.add(5);
        integers.add(7);

        var result = integers.stream()
                .reduce(1, (a, b) -> a * b);

        System.out.println("result : " + result);

        System.out.println("===reduce() with Optional()===");
        List<Integer> emptyList = new ArrayList<>();
        var ans = emptyList.stream().reduce((a, b) -> a * b);

        var ans01 = integers.stream().reduce((a, b) -> a * b);

        System.out.println(ans);
        System.out.println("ans01: " + ans01);

        System.out.println("===reduce() to get max gpa student");
        //alternative to comparator
        //application is to reduce the stream to single value
        var student = list.stream().reduce((s1, s2) -> s1.getGpa() > s2.getGpa() ? s1 : s2);
        System.out.println(student);



        /*
         *   Stream API
         *   map() - reduce()
         * */
        System.out.println("===classic stream-api map()-reduce()===");
        var totalNoOfNotebooks = list.stream().map(Student::getNoteBooks)
                //.reduce(0,(a,b)-> a+b);
                .reduce(0, Integer::sum);
        System.out.println(totalNoOfNotebooks);

        var totalNoOfNotebooksForGpaHigherThan3 = list.stream()
                .filter(s -> s.getGpa() > 4)
                .map(Student::getNoteBooks)
                .reduce(0, Integer::sum);

        System.out.println(totalNoOfNotebooksForGpaHigherThan3);

        //always use optional if returning a max or min value from reduce
        var max = integers.stream().reduce((s1, s2) -> s1 > s2 ? s1 : s2);
        var min = integers.stream().reduce((s1, s2) -> s1 < s2 ? s1 : s2);

        var intMax = integers.stream().reduce(Integer::max);
        var intMin = integers.stream().reduce(Integer::min);

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        System.out.println("Int Max: " + intMax);
        System.out.println("Int Min: " + intMin);

        var minWithDefault = integers.stream().reduce(0, (s1, s2) -> s1 < s2 ? s1 : s2);
        System.out.println("Min With default : " + minWithDefault);



        /*
         *   Stream API
         *   limit() - skip()
         * */
        System.out.println("===skip() and limit()===");

        List<Integer> integerList = Arrays.asList(4, 5, 6, 7, 8, 9);

        var limitResult = integerList.stream().limit(2).reduce(Integer::sum);

        System.out.println("Limit result: " + limitResult);

        var skipResult = integerList.stream().skip(3).reduce(Integer::min);
        System.out.println("Skip result : " + skipResult);



        /*
         *   Stream API
         *   anyMatch() - allMatch() - noneMatch()
         * */
        System.out.println("===allMatch(), anyMatch(), noneMatch()===");
        var isAllMatch01 = list.stream().map(Student::getGpa)
                .allMatch(s -> s > 3.7);
        var isAllMatch02 = list.stream().map(Student::getGpa)
                .allMatch(s -> s < 4.3);
        System.out.println("isAllMatch01: " + isAllMatch01);
        System.out.println("isAllMatch02: " + isAllMatch02);

        var isAnyMatch = list.stream().anyMatch(s -> s.getGpa() == 4.1);
        System.out.println("isAnyMatch: " + isAnyMatch);

        var isNoneMatch = list.stream().noneMatch(s -> s.getGpa() == 4.1);
        System.out.println("isAnyMatch: " + isNoneMatch);



        /*
         *   Stream API
         *   findFirst() - findAny()
         * */
        //both will return the first element
        //except when they are used with parallelStream()
        System.out.println("===findFirst() and findAny()===");
        var first = list.parallelStream().filter(s -> s.getGpa() > 3.9).findFirst().get();
        var any = list.parallelStream().filter(s -> s.getGpa() > 3.9).findFirst().get();

        System.out.println("findFirst(): " + first);
        System.out.println("findAny(): " + any);




        /*
         *   Stream APIS - ShortCircuit functions of Stream API
         *   limit() - findFirst() - findAny() - anyMatch() - allMatch() - noneMatch()
         * */


    }
}
