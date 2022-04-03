package learn.reflection.annotation;

public class AnnotationExample {
    /**
     * The same annotation can not be added again as
     * @CustomAnnotation is not a @Repeatable annotation Type
     *
     */
    @CustomAnnotation(priority = CustomAnnotation.Priority.HIGH)
    //@CustomAnnotation(priority = CustomAnnotation.Priority.MEDIUM)
    public void method01(){
        System.out.println("** This is inside the method01 ** "+ this.getClass());
    }


    public void method02(){
        System.out.println("** This is inside the method02 ** "+ this.getClass());
    }
}
