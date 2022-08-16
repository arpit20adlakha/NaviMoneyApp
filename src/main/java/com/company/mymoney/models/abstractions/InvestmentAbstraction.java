package com.company.mymoney.models.abstractions;

import com.company.mymoney.models.interfaces.InvestmentPlan;

public abstract class InvestmentAbstraction implements InvestmentPlan {
    private Integer equityValue;
    private Integer debtValue;
    private Integer goldValue;

    public InvestmentAbstraction(Integer equityValue, Integer debtValue, Integer goldValue) {
        this.equityValue = equityValue;
        this.goldValue = goldValue;
        this.debtValue = debtValue;
    }


}
