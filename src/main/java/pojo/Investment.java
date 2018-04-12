package pojo;

import java.math.BigDecimal;

public class Investment {

    private Long id;
    private String type;
    private String name;
    private Long amount;
    private BigDecimal percentage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public BigDecimal getPercentage() {
        return percentage.movePointRight(2);
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }
}
