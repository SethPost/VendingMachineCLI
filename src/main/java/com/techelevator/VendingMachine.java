package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    Map<VendingMachineItem, Integer> vendingMachineInventory = new HashMap<VendingMachineItem, int>();
    //Log printwriter here???
    //other instance variables if we need them?

    //Establishing the inventory
        try (Scanner inventoryScanner = new Scanner("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-team-6-take-2\\vendingmachine.csv")) {
           while (inventoryScanner.hasNextLine()) {
               String currentLine = inventoryScanner.nextLine();
               String[] itemDetails = currentLine.split("\\|");
               if (itemDetails[3].equals("Chip")) {
                   Chips name = new Chips(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Chips.CHIPS_MESSAGE);
                   vendingMachineInventory.put(name, 5);
               } else if (itemDetails[3].equals("Candy")) {
                   Candy name = new Candy(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Candy.CANDY_MESSAGE);
                   vendingMachineInventory.put(name, 5);
               } else if (itemDetails[3].equals("Drink")) {
                   Beverage name = new Beverage(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Beverage.BEVERAGE_MESSAGE);
                   vendingMachineInventory.put(name, 5);
               } else if (itemDetails[3].equals("Gum")) {
                   Gum name = new Gum(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Gum.GUM_MESSAGE);
                   vendingMachineInventory.put(name, 5);
               }
           }
        } catch (FileNotFoundException ex) {
        System.out.println("That file does not exist.");
    }
}
