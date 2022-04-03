package learn.reflection.annotation.repeatable;

@RepeatableCompany(name = "Thoughtworks", city = "Kormangala,Bengaluru")
@RepeatableCompany(name = "DELL EMC", city = "Bellandur,Bengaluru")
public class RepeatableAnnotationExample {
    private String about;

    public RepeatableAnnotationExample(String about) {
        this.about = about;
    }

    public String getAbout() {
        return about;
    }
}
