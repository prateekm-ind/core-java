package learn.objects;

import java.lang.reflect.Constructor;
import java.math.BigDecimal;

public class ExampleClass {
    private String name;
    private BigDecimal salary;


    /*
    *   Different ways of creating a class instance
    *
    * */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, CloneNotSupportedException {
        //using new keyword
        ExampleClass exmp01 = new ExampleClass();

        //using newInstance() - deprecated
        ExampleClass exmp02 = (ExampleClass) Class.forName("learn.objects.ExampleClass").newInstance();

        //using newInstance() - deprecated
        ExampleClass exmp03 = ExampleClass.class.newInstance();

        //using Constructor<T> class
        Constructor<ExampleClass> exmp04 = ExampleClass.class.getConstructor();

        //using the clone() method of the existing object
        ExampleClass exmp05 = (ExampleClass) exmp03.clone();

        //using the deserialization concept

    }
}
