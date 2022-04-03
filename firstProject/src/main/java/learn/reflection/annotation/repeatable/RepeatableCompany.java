package learn.reflection.annotation.repeatable;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(value = RepeatableCompanies.class)
public @interface RepeatableCompany {
    String name() default "Xebia";

    String city() default "Bengaluru";
}
