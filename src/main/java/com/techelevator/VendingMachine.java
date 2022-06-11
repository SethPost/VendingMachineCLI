package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class VendingMachine {
    //Instance variables
    private BigDecimal currentMoneyProvided;
    List<VendingMachineItem> vendingMachineInventory = new ArrayList<VendingMachineItem>();
    Scanner userInput = new Scanner(System.in);
    public static final BigDecimal QUARTER = new BigDecimal("0.25");
    public static final BigDecimal DIME = new BigDecimal("0.10");
    public static final BigDecimal NICKLE = new BigDecimal("0.05");


    public BigDecimal getCurrentMoneyProvided() {
        return currentMoneyProvided;
    }

    //Constructors
    public VendingMachine() {
    }

    public VendingMachine(BigDecimal currentMoneyProvided) {
        this.currentMoneyProvided = currentMoneyProvided;
    }
    //Log printwriter here???
    //other instance variables if we need them?

    //Establishing the inventory
    //Ask about try and catch error
    public void readInventoryFile() {
        File inventoryFile = new File("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-team-6-take-2\\vendingmachine.csv");
        try (Scanner inventoryScanner = new Scanner(inventoryFile)) {

            while (inventoryScanner.hasNextLine()) {
                String currentLine = inventoryScanner.nextLine();
                String[] itemDetails = currentLine.split("\\|");
                if (itemDetails[3].equals("Chip")) {
                    Chips chips = new Chips(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Chips.CHIPS_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                    vendingMachineInventory.add(chips);
                } else if (itemDetails[3].equals("Candy")) {
                    Candy candy = new Candy(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Candy.CANDY_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                    vendingMachineInventory.add(candy);
                } else if (itemDetails[3].equals("Drink")) {
                    Beverage beverage = new Beverage(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Beverage.BEVERAGE_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                    vendingMachineInventory.add(beverage);
                } else if (itemDetails[3].equals("Gum")) {
                    Gum gum = new Gum(itemDetails[1], new BigDecimal(itemDetails[2]), itemDetails[0], Gum.GUM_MESSAGE, VendingMachineItem.STARTING_QUANTITY);
                    vendingMachineInventory.add(gum);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("That file does not exist.");
        }
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
    public BigDecimal feedMoney(BigDecimal moneyAdded) {
        BigDecimal newBalance;
        newBalance = currentMoneyProvided.add(moneyAdded);
        currentMoneyProvided = newBalance;
        System.out.println("Total money added: $" + currentMoneyProvided);

        File log = new File("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-team-6-take-2\\Log.txt");
        try (PrintWriter transactionLog = new PrintWriter(
                new FileOutputStream(log, true)
        )) {
            // resource for finding how to get date and time - https://www.javatpoint.com/java-get-current-date
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
            LocalDateTime now = LocalDateTime.now();
            transactionLog.println(dtf.format(now) + " FEED MONEY: $" + moneyAdded + " $" + currentMoneyProvided);


        } catch (FileNotFoundException ex) {
            System.out.println("File not Found");
        }

        return currentMoneyProvided;

    }

    //Method used to select and buy product (Step 7 ii in Readme) (customer input "2" from purchase menu)
    public BigDecimal selectProduct(String userCode) {
        BigDecimal newBalance = new BigDecimal("0.00");
        List<String> itemCodes = new ArrayList<>();
        // Nest in while loop to return to purchase menu??
        for (VendingMachineItem vendingMachineItem : vendingMachineInventory) {
            itemCodes.add(vendingMachineItem.getCode());
        }
            if (itemCodes.contains(userCode)) {
                for (VendingMachineItem vendingMachineItem : vendingMachineInventory)
                if (!userCode.equalsIgnoreCase(vendingMachineItem.getCode())) {
                    continue;
                } else {
                    if (vendingMachineItem.getQuantity() > 0) {
                        vendingMachineItem.setQuantity(vendingMachineItem.getQuantity() - 1);
                        newBalance = currentMoneyProvided.subtract(vendingMachineItem.getPrice());
                        currentMoneyProvided = newBalance;
                        System.out.println(vendingMachineItem.getName() + " | Cost: $" + vendingMachineItem.getPrice()
                                + " | Money Remaining: $" + currentMoneyProvided);
                        System.out.println(vendingMachineItem.getMessage());

                        File log = new File("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-team-6-take-2\\Log.txt");
                        try (PrintWriter transactionLog = new PrintWriter(
                                new FileOutputStream(log, true)

                        )) {
                            // resource for finding how to get date and time - https://www.javatpoint.com/java-get-current-date
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
                            LocalDateTime now = LocalDateTime.now();
                            transactionLog.println(dtf.format(now) + " " + vendingMachineItem.getName() + " " + vendingMachineItem.getCode() + " $"
                                    + vendingMachineItem.getPrice() + " $" + currentMoneyProvided);


                        } catch (FileNotFoundException ex) {
                            System.out.println("File not Found");
                        }

                        //go back to purchase menu
                        return currentMoneyProvided;
                    } else {
                        System.out.println("Sorry, but that DELICIOUS item is sold out.");
                        //go back to purchase menu
                    }
                }
            } else {
                System.out.println("Sorry, that code is invalid.");
                //go back to purchase menu
            }return newBalance;


        }




    public BigDecimal finishTransaction() {
        BigDecimal quarterCounter = new BigDecimal("0");
        BigDecimal dimeCounter = new BigDecimal("0");
        BigDecimal nickleCounter = new BigDecimal("0");

        while (currentMoneyProvided.compareTo(QUARTER) >= 0) {
            BigDecimal newQuarterCounter = quarterCounter.add(new BigDecimal("1"));
            quarterCounter = newQuarterCounter;
            BigDecimal newBalance = currentMoneyProvided.subtract(QUARTER);
            currentMoneyProvided = newBalance;
        }
        while (currentMoneyProvided.compareTo(DIME) >= 0) {
            BigDecimal newDimeCounter = dimeCounter.add(new BigDecimal("1"));
            dimeCounter = newDimeCounter;
            BigDecimal newBalance = currentMoneyProvided.subtract(DIME);
            currentMoneyProvided = newBalance;
        }
        while (currentMoneyProvided.compareTo(NICKLE) >= 0) {
            BigDecimal newNickleCounter = nickleCounter.add(new BigDecimal("1"));
            nickleCounter = newNickleCounter;
            BigDecimal newBalance = currentMoneyProvided.subtract(NICKLE);
            currentMoneyProvided = newBalance;
        }
        BigDecimal totalChange = (QUARTER.multiply(quarterCounter)).add(DIME.multiply(dimeCounter)).add(NICKLE.multiply(nickleCounter));
        System.out.println("Your total change is $" + totalChange + ".");
        System.out.println("Total Quarters = " + quarterCounter);
        System.out.println("Total Dimes = " + dimeCounter);
        System.out.println("Total Nickles = " + nickleCounter);

        File log = new File("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-team-6-take-2\\Log.txt");
        try (PrintWriter transactionLog = new PrintWriter(
                new FileOutputStream(log, true)
        )) {
            // resource for finding how to get date and time - https://www.javatpoint.com/java-get-current-date
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
            LocalDateTime now = LocalDateTime.now();
            transactionLog.println(dtf.format(now) + " GIVE CHANGE: $" + totalChange + " $" + currentMoneyProvided);


        } catch (FileNotFoundException ex) {
            System.out.println("File not Found");


        }
        return currentMoneyProvided;
        // return to Main Menu

    }
}








