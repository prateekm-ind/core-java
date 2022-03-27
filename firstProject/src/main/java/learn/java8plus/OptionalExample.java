package learn.java8plus;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        String str= "Alexander";
        String sn = null;

        /*
        * - Will return Optional[]
        * */
        System.out.println(Optional.ofNullable(str));

        /*
        * - Optional.ofNullable(<object>) returns Optional.empty
        * - if <object> is null
        * */
        System.out.println("Null string: "+ Optional.ofNullable(sn));

    }
}
