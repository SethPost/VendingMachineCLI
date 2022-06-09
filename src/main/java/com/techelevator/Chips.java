package com.techelevator;

import java.math.BigDecimal;

public class Chips extends VendingMachineItem{
    private final String CHIPS_MESSAGE = "Crunch Crunch, Crunch!";
    public Chips(String name, BigDecimal price, int quantity, String code, String message) {
        super(name, price, quantity, code);
        message = CHIPS_MESSAGE;
    }

}
