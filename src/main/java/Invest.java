import pojo.Fund;
import pojo.InvestInput;
import pojo.InvestOutput;
import pojo.Investment;

import javax.ejb.Stateless;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class Invest {

    public InvestOutput investFoundsByStyle(InvestInput investInput){
        Map<String, BigDecimal> style = getStyleAggressiveness(investInput.getStyle());
        if (style == null) {
            return null;
        }

        Long i = 1L;
        Long investAmount = 0L;
        InvestOutput investOutput = new InvestOutput();
        List<Investment> investments = new ArrayList<>();
        String currentType = "";
        for (Fund fund: investInput.getFunds()){
            Investment investment = new Investment();
            investment.setId(i);
            investment.setType(fund.getType());
            investment.setName(fund.getName());
            BigDecimal percentage = style.get(fund.getType())
                    .divide(new BigDecimal(countFundTypes(investInput.getFunds(), fund.getType())),
                            4, BigDecimal.ROUND_DOWN);
            if (!currentType.equalsIgnoreCase(investment.getType())) {
                if (!percentage
                        .multiply(new BigDecimal(countFundTypes(investInput.getFunds(), fund.getType())))
                        .equals(style.get(fund.getType()).movePointRight(2))){
                    percentage = (style.get(fund.getType())
                            .subtract(percentage
                                    .multiply(new BigDecimal(countFundTypes(investInput.getFunds(), fund.getType()))
                                            .subtract(new BigDecimal("1")))));
                }
                currentType = investment.getType();
            }
            investment.setPercentage(percentage);
            BigDecimal amount = (new BigDecimal(investInput.getAmount()).multiply(percentage));
            investment.setAmount(amount.longValue());
            investAmount += amount.longValue();
            investments.add(investment);
            i += 1L;
        }
        investOutput.setInvestments(investments);
        investOutput.setRefund(investInput.getAmount() - investAmount);
        return investOutput;
    }

    public Long countFundTypes(List<Fund> funds, String type){
        return funds.stream()
                .filter(p -> p.getType().equalsIgnoreCase(type))
                .count();
    }

    private Map<String, BigDecimal> getStyleAggressiveness(String styleName){
        Map<String, BigDecimal> style = new HashMap<>();
        switch (styleName){
            case "bezpieczny":
                style.put(Const.POLISH, new BigDecimal("0.20"));
                style.put(Const.FOREIGN, new BigDecimal("0.75"));
                style.put(Const.CASH, new BigDecimal("0.05"));
                break;
            case "zrównoważony":
                style.put(Const.POLISH, new BigDecimal("0.30"));
                style.put(Const.FOREIGN, new BigDecimal("0.60"));
                style.put(Const.CASH, new BigDecimal("0.10"));
                break;
            case "agresywny":
                style.put(Const.POLISH, new BigDecimal("0.40"));
                style.put(Const.FOREIGN, new BigDecimal("0.20"));
                style.put(Const.CASH, new BigDecimal("0.40"));
                break;
            default:
                return null;
        }
        return style;
    }
}
