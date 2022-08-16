package com.company.mymoney.models;

import com.company.mymoney.Constants;
import com.company.mymoney.MONTHS;
import com.company.mymoney.models.abstractions.InvestmentAbstraction;
import com.company.mymoney.models.commands.AllocateCommand;
import com.company.mymoney.models.interfaces.Fund;

public class Portfolio {
    private Fund equity;
    private Fund debt;
    private Fund gold;
    private int[] portfolioDistribution;
    private InvestmentAbstraction investment;
    private MONTHS lastMonthChanged;


    public void setPortfolio(AllocateCommand allocateCommand) {
        this.equity = new Equity(allocateCommand.getEquity());
        this.debt = new Debt(allocateCommand.getDebt());
        this.gold = new Gold(allocateCommand.getGold());
        int totalAmount = allocateCommand.getEquity() + allocateCommand.getDebt() + allocateCommand.getGold();
        int equityPercent = allocateCommand.getEquity()/totalAmount;
        int debtPercent = allocateCommand.getDebt()/totalAmount;
        int goldPercent = allocateCommand.getGold()/totalAmount;

        portfolioDistribution = new int[] {equityPercent, debtPercent, goldPercent};
    }

    public void rebalance() {
        MONTHS currentMonth = MONTHS.valueOf("june".toUpperCase());

        if (lastMonthChanged.getValue() < currentMonth.getValue()) {
            System.out.println("CANNOT_REBALANCE");
            return;
        }

        long currentTotalAmount = 0;
        currentTotalAmount += this.equity.getCurrentMonthAmount("june") +
                              this.debt.getCurrentMonthAmount("june") +
                              this.gold.getCurrentMonthAmount("june");

        long equityAmount = portfolioDistribution[Constants.EquityDistribution] * currentTotalAmount/100;
        long debtAmount = portfolioDistribution[Constants.DebtDistribution] * currentTotalAmount/100;
        long goldAmount = portfolioDistribution[Constants.GoldDistribution] * currentTotalAmount/100;

        System.out.println(equityAmount + " " + debtAmount + " " + goldAmount);
    }

    public void balance() {

    }


}
