package com.company.mymoney.models.abstractions;

import com.company.mymoney.MONTHS;
import com.company.mymoney.models.interfaces.Fund;

import java.util.ArrayList;
import java.util.List;

public abstract class FundAbstraction implements Fund {
    private Integer initialAmount;
    private List<Integer> changePercentageList;
    private Integer sip;
    private List<Integer> monthFinalValue;
    public FundAbstraction(Integer initialAmount) {
        this.initialAmount = initialAmount;
        this.changePercentageList = new ArrayList<>();
    }

    public void addChangeAmount(Integer changePercentage) {
        changePercentageList.add(changePercentage);
    }

    @Override
    public long getCurrentMonthAmount(String month) {
        MONTHS monthValue = MONTHS.valueOf(month.toUpperCase());
        long sum = initialAmount;
        for (int i = 0; i < monthValue.getValue(); i++) {
            sum += changePercentageList.get(i) * (sum / 100);
            sum += sip;
        }
        return sum;
    }

}
