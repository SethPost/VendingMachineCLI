package com.techelevator;


import com.techelevator.view.MainMenu;
import com.techelevator.view.Menu;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.techelevator.VendingMachine;


public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";

    private static final String MAIN_MENU_OPTION_SECRET = "Secret Menu";

    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
            MAIN_MENU_OPTION_EXIT, MAIN_MENU_OPTION_SECRET};

    private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT,
            PURCHASE_MENU_FINISH_TRANSACTION};

    VendingMachine vendingMachine = new VendingMachine(new BigDecimal("0.00"));
    private Menu menu;
    private MainMenu mainMenu;


    public VendingMachineCLI(Menu menu, MainMenu mainMenu) {
        this.menu = menu;
        this.mainMenu = mainMenu;
    }

    public void run() throws InputMismatchException {
        vendingMachine.readInventoryFile();
        while (true) {


            String choice = (String) mainMenu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                // display vending machine items
                vendingMachine.displayItems();
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                while (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                    String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
                    // while (choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS)){
                    if (choice2.equals(PURCHASE_MENU_FEED_MONEY)) {
                        try {
                            System.out.println("Please enter the amount of money you wish to add (no more than $100.00 at a time, please): ");
                            Scanner userAddMoney = new Scanner(System.in);
                            BigDecimal moneyAdded = userAddMoney.nextBigDecimal();
                            vendingMachine.feedMoney(moneyAdded);

                        } catch (InputMismatchException ex) {
                            System.out.println("Input error - Please enter the amount of money you wish to add as numerical digits.");

                        }

                    } else if (choice2.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
                        vendingMachine.displayItems();
                        System.out.println("Please enter the code for the item you wish to purchase: ");
                        Scanner userSelection = new Scanner(System.in);
                        String userCode = userSelection.nextLine().toUpperCase();
                        vendingMachine.selectProduct(userCode);



                    } else if (choice2.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
                        vendingMachine.finishTransaction();
                        break;
                    }
                }
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                System.out.println("Thank you for using the vending machine. Have a great day!");
                break;
            } else if (choice.equals(MAIN_MENU_OPTION_SECRET)) {
                System.out.println("*** SECRET MENU ACCESSED ***");
                System.out.println();
                System.out.println(" ___  ___  _____ ______   ________  ________  _______   ___       ___       ________          ________  ________  ________  ________  ");
                System.out.println("|\\  \\|\\  \\|\\   _ \\  _   \\|\\   __  \\|\\   __  \\|\\  ___ \\ |\\  \\     |\\  \\     |\\   __  \\        |\\   ____\\|\\   __  \\|\\   __  \\|\\   __  \\");
                System.out.println("\\ \\  \\\\\\  \\ \\  \\\\\\__\\ \\  \\ \\  \\|\\ /\\ \\  \\|\\  \\ \\   __/|\\ \\  \\    \\ \\  \\    \\ \\  \\|\\  \\       \\ \\  \\___|\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\|\\  \\ ");
                System.out.println(" \\ \\  \\\\\\  \\ \\  \\\\|__| \\  \\ \\   __  \\ \\   _  _\\ \\  \\_|/_\\ \\  \\    \\ \\  \\    \\ \\   __  \\       \\ \\  \\    \\ \\  \\\\\\  \\ \\   _  _\\ \\   ____\\ ");
                System.out.println("  \\ \\  \\\\\\  \\ \\  \\    \\ \\  \\ \\  \\|\\  \\ \\  \\\\  \\\\ \\  \\_|\\ \\ \\  \\____\\ \\  \\____\\ \\  \\ \\  \\       \\ \\  \\____\\ \\  \\\\\\  \\ \\  \\\\  \\\\ \\  \\___|");
                System.out.println("   \\ \\_______\\ \\__\\    \\ \\__\\ \\_______\\ \\__\\\\ _\\\\ \\_______\\ \\_______\\ \\_______\\ \\__\\ \\__\\       \\ \\_______\\ \\_______\\ \\__\\\\ _\\\\ \\__\\");
                System.out.println("    \\|_______|\\|__|     \\|__|\\|_______|\\|__|\\|__|\\|_______|\\|_______|\\|_______|\\|__|\\|__|        \\|_______|\\|_______|\\|__|\\|__|\\|__|     ");
                System.out.println();
                System.out.println("*** CONFIDENTIAL ***");
                System.out.println();
                System.out.println("Umbrella Corporation's plan to take over the world is almost complete.");
                System.out.println("Our genius software developers Alex Giles and Seth Post have completed programming the vending machines that will");
                System.out.println("distribute products infected with the TE-virus to unsuspecting customers across the globe.");
                System.out.println("Our first target is Christopher Guarnera, the instructor who kickstarted our genius software developers' careers. How tragic.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        MainMenu mainMenu = new MainMenu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu, mainMenu);
        try {
            cli.run();
        } catch (InputMismatchException ex) {
            System.out.println("An input error occurred. Please try again.");

        }
    }
}
