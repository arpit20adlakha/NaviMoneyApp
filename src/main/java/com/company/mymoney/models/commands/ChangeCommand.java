package com.company.mymoney.models.commands;

import com.company.mymoney.models.Portfolio;
import com.company.mymoney.models.abstractions.Command;

public class ChangeCommand extends Command {
    private final Double equityPercent;
    private final Double debtPercent;
    private final Double goldPercent;
    private final String month;

    public ChangeCommand(String changeCommand) {
        String[] changePercentAndMonth = changeCommand.split(" ");

        this.equityPercent = Double.parseDouble(changePercentAndMonth[0].substring(0, changePercentAndMonth[0].length() - 1));
        this.debtPercent = Double.parseDouble(changePercentAndMonth[1].substring(0, changePercentAndMonth[1].length() - 1));
        this.goldPercent = Double.parseDouble(changePercentAndMonth[2].substring(0, changePercentAndMonth[2].length() - 1));
        this.month = changePercentAndMonth[3];
    }

    @Override
    public void execute(Portfolio portfolio) {

    }
}
