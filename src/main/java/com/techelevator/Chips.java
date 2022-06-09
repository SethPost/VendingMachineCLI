package com.techelevator;

import java.math.BigDecimal;

public class Chips extends VendingMachineItem{
    public static final String CHIPS_MESSAGE = "Crunch Crunch, Crunch!";
    public Chips(String name, BigDecimal price, String code, String message, int quantity) {
        super(name, price, code, quantity);
        message = CHIPS_MESSAGE;
    }

}
