package com.company.mymoney.models.commands;

import com.company.mymoney.models.Portfolio;
import com.company.mymoney.models.abstractions.Command;
import lombok.Getter;


@Getter
public class AllocateCommand extends Command {
    private Integer equity;
    private Integer debt;
    private Integer gold;


    public AllocateCommand(String allocationInput) {
        try {
            String[] fundDistributions = allocationInput.split(" ");
            this.equity = Integer.parseInt(fundDistributions[0]);
            this.debt = Integer.parseInt(fundDistributions[1]);
            this.gold = Integer.parseInt(fundDistributions[2]);
        } catch(NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
        }
    }

    @Override
    public void execute(Portfolio portfolio) {
        portfolio.setPortfolio(this);
    }

}
