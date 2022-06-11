package com.techelevator;

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
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
	MAIN_MENU_OPTION_EXIT};

	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT,
	PURCHASE_MENU_FINISH_TRANSACTION};

	VendingMachine vendingMachine = new VendingMachine(new BigDecimal("0.00"));

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws InputMismatchException {
		while (true) {

			vendingMachine.readInventoryFile();
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				vendingMachine.displayItems();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					if (choice2.equals(PURCHASE_MENU_FEED_MONEY)) {
						System.out.println("Please enter the amount of money you wish to add (whole dollar amounts only, please): ");
						Scanner userAddMoney = new Scanner(System.in);
						BigDecimal moneyAdded = userAddMoney.nextBigDecimal();
						vendingMachine.feedMoney(moneyAdded);
					} else if (choice2.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
						vendingMachine.displayItems();
						System.out.println("Please enter the code for the item you wish to purchase: ");
						Scanner userSelection = new Scanner(System.in);
						String userCode = userSelection.nextLine();
						vendingMachine.selectProduct(userCode);

					}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {

				// do exit
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		try {
			cli.run();
		} catch (InputMismatchException ex) {
			System.out.println("An error occurred.");
		}
	}
}
