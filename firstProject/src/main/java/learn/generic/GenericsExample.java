package learn.generic;

//Generic class definition
public class GenericsExample<T>{
    T member;

    /*
    * Advantages of generics
    * Stronger type checks at compile time
    * Java compiler applies strong type checking to generic code and issues error if the code violates
    *
    * Elimination of cast
    *
    * Enable programmers to implement generic algorithm
    * */

    public GenericsExample(T member) {
        this.member = member;
    }

    //generics method definition
    public <T> void genericsMethodExample(T input){
        System.out.println("this method deals with generics of type T");
    }
}
