package learn.serialization;

import java.math.BigDecimal;

public class Example {
    public static void main(String[] args) {
        SerializationExample object = new SerializationExample();
        object.setName("PRATEEK");
        object.setBankBalance(BigDecimal.valueOf(310000.00));
    }
}
