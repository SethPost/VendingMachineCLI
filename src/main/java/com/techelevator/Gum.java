package com.techelevator;

import java.math.BigDecimal;

public class Gum extends VendingMachineItem {
    private final String GUM_MESSAGE = "Chew Chew, Pop!";
    public Gum(String name, BigDecimal price, int quantity, String code, String message){
        super(name, price, quantity, code);
        message = GUM_MESSAGE;
    }

}
