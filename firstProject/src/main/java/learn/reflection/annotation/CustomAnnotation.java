package learn.reflection.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CustomAnnotation {
    public enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    public enum Status {
        STARTED,
        NOT_STARTED
    }

    String author() default "Prateek";

    Priority priority() default Priority.LOW;

    Status status() default Status.NOT_STARTED;
}
