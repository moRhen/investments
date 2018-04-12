package pojo;

import java.util.List;

public class InvestInput {

    private Long amount;
    private String style;
    private List<Fund> funds;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public List<Fund> getFunds() {
        return funds;
    }

    public void setFunds(List<Fund> funds) {
        this.funds = funds;
    }
}
