package com.company.mymoney.factories;


import com.company.mymoney.models.abstractions.Command;
import com.company.mymoney.models.commands.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommandFactory {

    public static Command getCommandInstance(String commandLine) {
        String commandType = commandLine.split(" ")[0].toLowerCase();
        String inputLine = commandLine.split(" ")[1];

        switch (commandType) {
            case "allocate":
                return new AllocateCommand(inputLine);
            case "sip":
                return new SIPCommand(inputLine);
            case "change":
                return new ChangeCommand(inputLine);
            case "balance":
                return new BalanceCommand();
            case "rebalance":
                return new RebalanceCommand();
            default:
                return null;
        }
    }
}
