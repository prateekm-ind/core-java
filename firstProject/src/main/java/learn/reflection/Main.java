package learn.reflection;

import learn.reflection.annotation.AnnotationExample;
import learn.reflection.annotation.CustomAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Using Java Reflection API we are invoking the method01 of ReflectionExample.class
 * @Annotated method is invoked at the Runtime
 *
 *
 */
public class Main {

    public static void main(String[] args) {
        Class<AnnotationExample> reflectionExampleClass = AnnotationExample.class;

        for (Method method : reflectionExampleClass.getDeclaredMethods()) {
            Annotation annotation = method.getAnnotation(CustomAnnotation.class);

            CustomAnnotation customAnnotation = (CustomAnnotation) annotation;

            if (customAnnotation != null) {
                try {
                    System.out.println("author : " + customAnnotation.author() + "  priority: " + customAnnotation.priority());
                    method.invoke(reflectionExampleClass
                            .getDeclaredConstructor()
                            .newInstance());
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
