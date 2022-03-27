package learn.serialization;

import java.io.Serializable;
import java.math.BigDecimal;

public class SerializationExample implements Serializable {

    private String name;
    private BigDecimal bankBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(BigDecimal bankBalance) {
        this.bankBalance = bankBalance;
    }
}
