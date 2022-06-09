package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    private BigDecimal currentMoneyProvided;

    List<VendingMachineItem> vendingMachineInventory = new ArrayList<VendingMachineItem>() {
        //Log printwriter here???
        //other instance variables if we need them?

        //Establishing the inventory
        try(Scanner inventoryScanner = new Scanner("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-team-6-take-2\\vendingmachine.csv")){
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
        } catch(
        FileNotFoundException ex);

        {
            System.out.println("That file does not exist.");
        }

        public void displayItems() {
            for (VendingMachineItem vendingMachineItem : vendingMachineInventory) {
                if (vendingMachineItem.getQuantity() > 0) {
                    System.out.println(vendingMachineItem.getCode() + " | " + vendingMachineItem.getName() + " | $" + vendingMachineItem.getPrice() + " | "
                            + "Quantity: "vendingMachineItem.getQuantity());
                } else {
                    System.out.println(System.out.println(vendingMachineItem.getCode() + " | " + vendingMachineItem.getName() + " | $" + vendingMachineItem.getPrice() + " | SOLD OUT"));
                }
            }
        }
    }
    }
