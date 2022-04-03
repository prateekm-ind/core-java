package learn.reflection.annotation.repeatable;

import java.lang.annotation.Annotation;

public class Main {

    public static void main(String[] args) {
        RepeatableAnnotationExample repeatableAnnotationExample = new RepeatableAnnotationExample("India");
        Class<? extends RepeatableAnnotationExample> clazz = repeatableAnnotationExample.getClass();

        Annotation[] annotations = clazz.getAnnotations();

        /**
         * - Fetching the annotations using the concept of Reflection
         *
         */
        RepeatableCompany[] repeatableCompanies = clazz.getAnnotationsByType(RepeatableCompany.class);

        try {
            if(repeatableCompanies!=null){
                for(RepeatableCompany companies : repeatableCompanies){
                    System.out.println(companies.city());
                    System.out.println(companies.name());
                    System.out.println("*** --- ***");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
