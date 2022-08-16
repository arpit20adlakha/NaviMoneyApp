package com.company.mymoney.models.abstractions;

import com.company.mymoney.models.Portfolio;

import java.util.ArrayDeque;
import java.util.Deque;

public abstract class Command {
    public Deque<String> changeCommand;

    public Command() {
        changeCommand = new ArrayDeque<String>();
    }

    public void addCommand(String month) {
        changeCommand.addLast(month);
    }

    public String getLastMonthCommand() {
        return changeCommand.peek();
    }

    public abstract void execute(Portfolio portfolio);
}
