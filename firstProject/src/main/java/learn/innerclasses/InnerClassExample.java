package learn.innerclasses;

public class InnerClassExample {

    //Note : we can't declare any static member inside inner class
    //Hence we can't declare main method inside inner class and can't run it directly from
    //command prompt

    private String outerClassName;

    //application: If one kind of object can not exist without another type of object
    //then we should go for inner classes
    // relationship {HAS -> A} composition or aggregation
    public class InnerClassDemo {
        private String innerClassName;
    }

    //inner class can be private
    //inner class file InnerClassExample$PrivateInnerClass.class
    private class PrivateInnerClass {

    }
}
