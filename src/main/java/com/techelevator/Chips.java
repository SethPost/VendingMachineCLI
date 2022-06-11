package com.techelevator;

import java.math.BigDecimal;

public class Chips extends VendingMachineItem{
    public static final String CHIPS_MESSAGE = "Crunch Crunch, Crunch!";
    public Chips(String name, BigDecimal price, String code, String CHIPS_MESSAGE, int quantity) {
        super(name, price, code);
        this.message = CHIPS_MESSAGE;
    }

    @Override
    public String getMessage() {
        return CHIPS_MESSAGE;
    }

}
