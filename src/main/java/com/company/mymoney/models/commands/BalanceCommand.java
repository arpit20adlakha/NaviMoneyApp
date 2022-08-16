package com.company.mymoney.models.commands;

import com.company.mymoney.models.Portfolio;
import com.company.mymoney.models.abstractions.Command;

public class BalanceCommand extends Command {

    @Override
    public void execute(Portfolio portfolio) {
        portfolio.balance();
    }
}
