package com.company.mymoney.models;

import com.company.mymoney.models.abstractions.InvestmentAbstraction;

public class SIP extends InvestmentAbstraction {

    public SIP(Integer equityValue, Integer debtValue, Integer goldValue) {
       super(equityValue, debtValue, goldValue);
    }

}
