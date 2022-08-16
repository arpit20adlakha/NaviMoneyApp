package com.company.mymoney;

import com.company.mymoney.models.Portfolio;
import com.company.mymoney.models.abstractions.Command;
import com.company.mymoney.factories.CommandFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MoneyApplication {
    public static void main(String[] args) {
        Portfolio portfolio = new Portfolio();

        // Process the File
        try {
            String fileName = args[0];
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String currentLine = reader.readLine();
            while (currentLine != null) {
                currentLine = reader.readLine();
                Command commandInstance = CommandFactory.getCommandInstance(currentLine);
                commandInstance.execute(portfolio);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Terminated File Not Found " + fileNotFoundException.getMessage());
        } catch (IOException ioException) {
            System.out.println("Error Reading File " + ioException.getMessage());
        }



    }
}
