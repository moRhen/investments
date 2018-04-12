package pojo;

import java.util.List;

public class InvestOutput {

    private Long refund;
    private List<Investment> investments;

    public Long getRefund() {
        return refund;
    }

    public void setRefund(Long refund) {
        this.refund = refund;
    }

    public List<Investment> getInvestments() {
        return investments;
    }

    public void setInvestments(List<Investment> investments) {
        this.investments = investments;
    }
}
