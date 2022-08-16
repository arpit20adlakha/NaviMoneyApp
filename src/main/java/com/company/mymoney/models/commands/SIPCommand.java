package com.company.mymoney.models.commands;

import com.company.mymoney.models.abstractions.Command;

public class SIPCommand extends Command {
    private Integer equity;
    private Integer debt;
    private Integer gold;


    public SIPCommand(String inputLine) {
        String[] sipDistribution = inputLine.split(" ");
        this.equity = Integer.parseInt(sipDistribution[0]);
        this.debt = Integer.parseInt(sipDistribution[1]);
        this.gold = Integer.parseInt(sipDistribution[2]);
    }

    public void execute() {

    }
}
