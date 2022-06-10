package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {
    //Instance variables
    private BigDecimal currentMoneyProvided;
    List<VendingMachineItem> vendingMachineInventory = new ArrayList<VendingMachineItem>();
    Scanner userInput = new Scanner(System.in);
    public static final BigDecimal QUARTER = new BigDecimal("0.25");
    public static final BigDecimal DIME = new BigDecimal("0.10");
    public static final BigDecimal NICKLE = new BigDecimal("0.05");


    //Constructor
    public VendingMachine() {
        this.currentMoneyProvided = currentMoneyProvided;
    }
    //Log printwriter here???
    //other instance variables if we need them?

    //Establishing the inventory
    //Ask about try and catch error
        try(
    Scanner inventoryScanner = new Scanner("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-team-6-take-2\\vendingmachine.csv"))

    {
        while (inventoryScanner.hasNextLine()) {
            String currentLine = inventoryScanner.nextLine();
            String[] itemDetails = currentLine.split("\\|");
            if (itemDetails[0].equals("A1")) {
                Chips potatoCrisps = new Chips(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Chips.CHIPS_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                vendingMachineInventory.add(potatoCrisps);
            } else if (itemDetails[0].equals("A2")) {
                Chips stackers = new Chips(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Chips.CHIPS_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                vendingMachineInventory.add(stackers);
            } else if (itemDetails[0].equals("A3")) {
                Chips grainWaves = new Chips(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Chips.CHIPS_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                vendingMachineInventory.add(grainWaves);
            } else if (itemDetails[0].equals("A4")) {
                Chips cloudPopcorn = new Chips(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Chips.CHIPS_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                vendingMachineInventory.add(cloudPopcorn);
            } else if (itemDetails[0].equals("B1")) {
                Candy moonPie = new Candy(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Candy.CANDY_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                vendingMachineInventory.add(moonPie);
            } else if (itemDetails[0].equals("B2")) {
                Candy cowTails = new Candy(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Candy.CANDY_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                vendingMachineInventory.add(cowTails);
            } else if (itemDetails[0].equals("B3")) {
                Candy wonkaBar = new Candy(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Candy.CANDY_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                vendingMachineInventory.add(wonkaBar);
            } else if (itemDetails[0].equals("B4")) {
                Candy crunchie = new Candy(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Candy.CANDY_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                vendingMachineInventory.add(crunchie);
            } else if (itemDetails[3].equals("C1")) {
                Beverage cola = new Beverage(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Beverage.BEVERAGE_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                vendingMachineInventory.add(cola);
            } else if (itemDetails[3].equals("C2")) {
                Beverage drSalt = new Beverage(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Beverage.BEVERAGE_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                vendingMachineInventory.add(drSalt);
            } else if (itemDetails[3].equals("C3")) {
                Beverage mountainMelter = new Beverage(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Beverage.BEVERAGE_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                vendingMachineInventory.add(mountainMelter);
            } else if (itemDetails[3].equals("C4")) {
                Beverage heavy = new Beverage(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Beverage.BEVERAGE_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                vendingMachineInventory.add(heavy);
            } else if (itemDetails[3].equals("D1")) {
                Gum uChews = new Gum(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Gum.GUM_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                vendingMachineInventory.add(uChews);
            } else if (itemDetails[3].equals("D2")) {
                Gum littleLeague = new Gum(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Gum.GUM_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                vendingMachineInventory.add(littleLeague);
            } else if (itemDetails[3].equals("D3")) {
                Gum chiclets = new Gum(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Gum.GUM_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                vendingMachineInventory.add(chiclets);
            } else if (itemDetails[3].equals("D4")) {
                Gum triplemint = new Gum(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Gum.GUM_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                vendingMachineInventory.add(triplemint);
            }
        }
        //Ask about try and catch error?
    } catch(
    FileNotFoundException ex)

    {
        System.out.println("That file does not exist.");
    }

    //Method that displays vending machine items (customer input "1" from main menu)
    public void displayItems() {
        for (VendingMachineItem vendingMachineItem : vendingMachineInventory) {
            if (vendingMachineItem.getQuantity() > 0) {
                System.out.println(vendingMachineItem.getCode() + " | " + vendingMachineItem.getName() + " | $" + vendingMachineItem.getPrice() + " | "
                        + "Quantity: " + vendingMachineItem.getQuantity());
            } else {
                System.out.println(vendingMachineItem.getCode() + " | " + vendingMachineItem.getName() + " | $" + vendingMachineItem.getPrice() + " | SOLD OUT");
            }
        }
    }

    //Method that adds a dollar to the total money provided by customer (customer input "1" from purchase menu)
    public BigDecimal feedMoney() {
        currentMoneyProvided.add(new BigDecimal("1.00"));
        System.out.println(currentMoneyProvided);
        return currentMoneyProvided;
    }

    //Method used to select and buy product (Step 7 ii in Readme) (customer input "2" from purchase menu)
    public BigDecimal selectProduct() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.displayItems();
        String userCode = userInput.nextLine();
        // Nest in while loop to return to purchase menu??
        for (VendingMachineItem vendingMachineItem : vendingMachineInventory) {
            if (userCode.equalsIgnoreCase(vendingMachineItem.getCode())) {
                if (vendingMachineItem.getQuantity() > 0) {
                    vendingMachineItem.setQuantity(vendingMachineItem.getQuantity() - 1);
                    currentMoneyProvided.subtract(vendingMachineItem.getPrice());
                    System.out.println(vendingMachineItem.getName() + " | Cost: $" + vendingMachineItem.getPrice()
                            + " | Money Remaining: $" + currentMoneyProvided);
                    System.out.println(vendingMachineItem.getMessage());
                    //go back to purchase menu
                } else {
                    System.out.println("Sorry, but that DELICIOUS item is sold out.");
                    //go back to purchase menu
                }
            } else {
                System.out.println("Sorry, that code is invalid.");
                //go back to purchase menu
            }
        }
        return currentMoneyProvided;

    }

    public BigDecimal finishTransaction() {
        BigDecimal quarterCounter = new BigDecimal("0");
        BigDecimal dimeCounter = new BigDecimal("0");
        BigDecimal nickleCounter = new BigDecimal("0");


        String[] coin = new String[]{"Quarter(s)", "Dime(s)", "Nickle(s)"};
        while (currentMoneyProvided.compareTo(QUARTER) >= 0 {
            quarterCounter.add(new BigDecimal("1"));
            currentMoneyProvided.subtract(QUARTER);
        }
        while (currentMoneyProvided.compareTo(DIME) >= 0 {
            dimeCounter.add(new BigDecimal("1"));
            currentMoneyProvided.subtract(DIME);
        }
        while (currentMoneyProvided.compareTo(NICKLE) >= 0 {
            nickleCounter.add(new BigDecimal("1"));
            currentMoneyProvided.subtract(NICKLE);
        }
        BigDecimal totalChange = (QUARTER.multiply(quarterCounter)).add(DIME.multiply(dimeCounter)).add(NICKLE.multiply(nickleCounter));
        System.out.println("Your total change is $" + totalChange + ".");
        System.out.println("Total Quarters = " + quarterCounter);
        System.out.println("Total Dimes = " + dimeCounter);
        System.out.println("Total Nickles = " + nickleCounter);
        return currentMoneyProvided;
        // return to Main Menu
        }

}

