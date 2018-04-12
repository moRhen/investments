import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pojo.Fund;
import pojo.InvestInput;
import pojo.InvestOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class InvestmentsTest {

    private static Invest invest;

    @BeforeClass
    public static void setUp() {
        invest = new Invest();
    }

    @Test
    public void checkFundTypesCount() throws Exception{

        List<Fund> funds = new ArrayList<>();
        List<String> types = Arrays.asList(
                "Polskie", "Polskie", "Zagraniczne", "Pieniężne", "Pieniężne", "Pieniężne");
        for (String type:types){
            Fund fund = new Fund();
            fund.setType(type);
            funds.add(fund);
        }
        Long polishTypeAmount = invest.countFundTypes(funds, "polskie");
        Long foreignTypeAmount = invest.countFundTypes(funds, "zagraniczne");
        Long cashTypeAmount = invest.countFundTypes(funds, "pieniężne");

        assertEquals((Long) 2L, polishTypeAmount);
        assertEquals((Long) 1L, foreignTypeAmount);
        assertEquals((Long) 3L, cashTypeAmount);
    }

    @Test
    public void checkInvestmentSplitExample1() throws Exception{

        InvestInput investInput = new InvestInput();
        investInput.setAmount(10000L);
        investInput.setStyle("bezpieczny");
        List<Fund> funds = new ArrayList<>();
        List<String> types = Arrays.asList(
                "Polskie", "Polskie", "Zagraniczne", "Zagraniczne", "Zagraniczne", "Pieniężne");
        List<Long> amounts = Arrays.asList(1000L, 1000L, 2500L, 2500L, 2500L, 500L);
        for (String type:types){
            Fund fund = new Fund();
            fund.setType(type);
            funds.add(fund);
        }
        investInput.setFunds(funds);

        InvestOutput investOutput = invest.investFoundsByStyle(investInput);

        assertEquals((Long) 0L, investOutput.getRefund());
        for (int i=0; i<investOutput.getInvestments().size(); i++){
            assertEquals(amounts.get(i), investOutput.getInvestments().get(i).getAmount());
        }
    }

    @Test
    public void checkInvestmentSplitExample2() throws Exception{

        InvestInput investInput = new InvestInput();
        investInput.setAmount(10001L);
        investInput.setStyle("bezpieczny");
        List<Fund> funds = new ArrayList<>();
        List<String> types = Arrays.asList(
                "Polskie", "Polskie", "Zagraniczne", "Zagraniczne", "Zagraniczne", "Pieniężne");
        List<Long> amounts = Arrays.asList(1000L, 1000L, 2500L, 2500L, 2500L, 500L);
        for (String type:types){
            Fund fund = new Fund();
            fund.setType(type);
            funds.add(fund);
        }
        investInput.setFunds(funds);

        InvestOutput investOutput = invest.investFoundsByStyle(investInput);

        assertEquals((Long) 1L, investOutput.getRefund());
        for (int i=0; i<investOutput.getInvestments().size(); i++){
            assertEquals(amounts.get(i), investOutput.getInvestments().get(i).getAmount());
        }
    }

    @Test
    public void checkInvestmentSplitExample3() throws Exception{

        InvestInput investInput = new InvestInput();
        investInput.setAmount(10000L);
        investInput.setStyle("bezpieczny");
        List<Fund> funds = new ArrayList<>();
        List<String> types = Arrays.asList(
                "Polskie", "Polskie", "Polskie", "Zagraniczne", "Zagraniczne", "Pieniężne");
        List<Long> amounts = Arrays.asList(668L, 666L, 666L, 3750L, 3750L, 500L);
        for (String type:types){
            Fund fund = new Fund();
            fund.setType(type);
            funds.add(fund);
        }
        investInput.setFunds(funds);

        InvestOutput investOutput = invest.investFoundsByStyle(investInput);

        assertEquals((Long) 0L, investOutput.getRefund());
        for (int i=0; i<investOutput.getInvestments().size(); i++){
            assertEquals(amounts.get(i), investOutput.getInvestments().get(i).getAmount());
        }
    }
}
