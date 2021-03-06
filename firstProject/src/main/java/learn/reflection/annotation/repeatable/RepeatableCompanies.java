package learn.reflection.annotation.repeatable;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatableCompanies{
    RepeatableCompany[] value() default {};
}
